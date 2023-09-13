package com.woniuxy.user.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.woniuxy.user.entity.*;
import com.woniuxy.user.pojos.ResponseResult;
import com.woniuxy.user.service.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@RestController
@RequestMapping("/magnetometer-log")
public class MagnetometerLogController {

    private final IMagnetometerLogService magnetometerLogServiceImpl;
    private final IMagnetometerService magnetometerServiceImpl;
    private final IParkingService parkingServiceImpl;
    private final IOrderService orderServiceImpl;
    private final IRoadService roadServiceImpl;
    private final IChargeService chargeServiceImpl;
    private final RabbitTemplate rabbitTemplate;


    public MagnetometerLogController(IMagnetometerLogService magnetometerLogServiceImpl, IMagnetometerService magnetometerServiceImpl, IParkingService parkingServiceImpl, IOrderService orderServiceImpl, IRoadService roadServiceImpl, IChargeService chargeServiceImpl, RabbitTemplate rabbitTemplate) {
        this.magnetometerLogServiceImpl = magnetometerLogServiceImpl;
        this.magnetometerServiceImpl = magnetometerServiceImpl;
        this.parkingServiceImpl = parkingServiceImpl;
        this.orderServiceImpl = orderServiceImpl;
        this.roadServiceImpl = roadServiceImpl;
        this.chargeServiceImpl = chargeServiceImpl;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Transactional
    @PostMapping("/carIn")
    public ResponseResult carIn(Integer id) {
        Magnetometer magnetometer = magnetometerServiceImpl.getById(id);
        // magnetometer_log表新增一条驶入记录
        MagnetometerLog magnetometerLog = new MagnetometerLog(null, id, magnetometer.getStatus(), 0, DateTime.now());
        magnetometerLogServiceImpl.save(magnetometerLog);
        Integer generatedId = magnetometerLog.getId();

        // 放入死信队列，5分钟后进行检验
        rabbitTemplate.convertAndSend("car_in_dead_letter_exchange", "dead_routing_key", generatedId);
        return ResponseResult.ok();
    }

    @Transactional
    @PostMapping("/carOut")
    public ResponseResult carOut(Integer id) {
        Magnetometer magnetometer = magnetometerServiceImpl.getById(id);
        // magnetometer_log表新增一条驶出记录
        magnetometerLogServiceImpl.save(new MagnetometerLog(null, id, magnetometer.getStatus(), 1, DateTime.now()));

        // 判断车位状态是否为有车（即有进行中订单）
        Parking parking = parkingServiceImpl.getOne(
                new LambdaQueryWrapper<Parking>()
                        .eq(Parking::getMagnetometerId, id));
        if (parking.getStatus() == 0) {//1没车0有车 如果有车，即有订单
            // 获得对应订单
            Order order = orderServiceImpl.getOne(
                    new LambdaQueryWrapper<Order>()
                            .eq(Order::getParkingId, parking.getId())
                            .eq(Order::getStatus, 6)
            );
            // 获得order对应的当前时段的收费标准
            Charge charge = getCharge(order);
            // 获得计费时段
            BigDecimal chargeHours;
            if (order.getUpdateTime() == null) { // 如果update_time为空 => 说明是在本时段内才开始停车
                // 直接计算当前时间-create_time作为停车时间
                LocalDateTime startTime = order.getCreateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                chargeHours = getChargeHours(charge, startTime);
            } else { // 计算当前时间-update_time作为停车时间
                LocalDateTime startTime = order.getUpdateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                chargeHours = getChargeHours(charge, startTime);
            }
            // 计算收费金额
            BigDecimal orderAmount = new BigDecimal(charge.getChargeRate().toString()).multiply(chargeHours);
            orderAmount = orderAmount.min(charge.getMaximumCharge());
            // 修改订单表中对应的订单状态改为待支付，金额为计算出来的订单金额
            orderServiceImpl.update(
                    new UpdateWrapper<Order>()
                            .eq("id", order.getId())
                            .set("status", 1)
                            .set("order_amount", orderAmount)
                            .set("update_time",DateTime.now()));
            // 车位状态变为无车
            parkingServiceImpl.update(new UpdateWrapper<Parking>()
                    .eq("magnetometer_id", id)
                    .set("status", 1));
        }
        return ResponseResult.ok();
    }

    private static BigDecimal getChargeHours(Charge charge, LocalDateTime startTime) {
        Duration duration = Duration.between(startTime, LocalDateTime.now());
        Integer freeMinutes = charge.getFreeDuration();
        long parkedMinutes = duration.toMinutes();
        BigDecimal chargeHours=new BigDecimal("0");
        if (parkedMinutes > freeMinutes) { // 如果停车时限超过免费时间
            chargeHours = chargeHours.add(new BigDecimal(parkedMinutes - freeMinutes).divide(new BigDecimal(60), 2, RoundingMode.HALF_UP));
        }
        return chargeHours;
    }

    private Charge getCharge(Order order) {
        Road road = roadServiceImpl.getOne(
                new LambdaQueryWrapper<Road>()
                        .eq(Road::getId, order.getRoadId())
        );
        // 判断现在时间
        LocalTime now = LocalTime.now();
        Charge charge;
        // 如果是白天
        if (now.isAfter(LocalTime.of(9,00))&&now.isBefore(LocalTime.of(19,00))){
            charge = chargeServiceImpl.getOne(
                    new LambdaQueryWrapper<Charge>()
                            .eq(Charge::getCid, road.getChargeId())
                            .eq(Charge::getTimePeriod, "9:00-19:00")
            );
        }else{ // 如果是晚上
            charge = chargeServiceImpl.getOne(
                    new LambdaQueryWrapper<Charge>()
                            .eq(Charge::getCid, road.getChargeId())
                            .eq(Charge::getTimePeriod, "19:00-次日9:00")
            );
        }
        return charge;
    }
}
