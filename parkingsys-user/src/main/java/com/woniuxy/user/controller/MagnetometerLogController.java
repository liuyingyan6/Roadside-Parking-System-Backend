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
    private final RabbitTemplate rabbitTemplate;


    public MagnetometerLogController(IMagnetometerLogService magnetometerLogServiceImpl, IMagnetometerService magnetometerServiceImpl, IParkingService parkingServiceImpl, IOrderService orderServiceImpl, IRoadService roadServiceImpl, RabbitTemplate rabbitTemplate) {
        this.magnetometerLogServiceImpl = magnetometerLogServiceImpl;
        this.magnetometerServiceImpl = magnetometerServiceImpl;
        this.parkingServiceImpl = parkingServiceImpl;
        this.orderServiceImpl = orderServiceImpl;
        this.roadServiceImpl = roadServiceImpl;
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
        if (parking.getStatus() == 0) {//1没车0有车 如果有车
            // 根据驶入和驶出时间，结合路段收费标准表计算订单金额
            BigDecimal orderAmount = new BigDecimal("100");
            // 修改订单表中对应的订单状态改为待支付，金额为计算出来的订单金额
            orderServiceImpl.update(
                    new UpdateWrapper<Order>()
                            .eq("parking_id", parking.getId())
                            .eq("status", 6)
                            .set("status", 1)
                            .set("order_amount", orderAmount));
            // 车位状态变为无车
            parkingServiceImpl.update(new UpdateWrapper<Parking>()
                    .eq("magnetometer_id", id)
                    .set("status", 1));

        }
        return ResponseResult.ok();
    }
}
