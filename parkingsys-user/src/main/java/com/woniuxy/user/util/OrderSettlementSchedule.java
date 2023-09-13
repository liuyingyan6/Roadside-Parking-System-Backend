package com.woniuxy.user.util;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.woniuxy.user.entity.Charge;
import com.woniuxy.user.entity.Order;
import com.woniuxy.user.entity.Road;
import com.woniuxy.user.service.IChargeService;
import com.woniuxy.user.service.IOrderService;
import com.woniuxy.user.service.IRoadService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Component
@EnableScheduling
public class OrderSettlementSchedule {
    private final IOrderService orderServiceImpl;
    private final IChargeService chargeServiceImpl;
    private final IRoadService roadServiceImpl;

    public OrderSettlementSchedule(IOrderService orderServiceImpl, IChargeService chargeServiceImpl, IRoadService roadServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
        this.chargeServiceImpl = chargeServiceImpl;
        this.roadServiceImpl = roadServiceImpl;
    }

    // 每天早上7点执行 结算夜晚时段
    @Scheduled(cron = "0 0 7 * * ?")
    public void morningTask() {
        // 查找所有进行中订单
        List<Order> ordersInProgress = orderServiceImpl.list(
                new LambdaQueryWrapper<Order>()
                        .eq(Order::getStatus, 6));
        // 判断本时段内的停车时间，并计算本时段的费用，修改update time
        ordersInProgress.forEach(o -> {
            Road road = roadServiceImpl.getOne(
                    new LambdaQueryWrapper<Road>()
                            .eq(Road::getId, o.getRoadId())
            );
            Charge charge = chargeServiceImpl.getOne(
                    new LambdaQueryWrapper<Charge>()
                            .eq(Charge::getCid, road.getChargeId())
                            .eq(Charge::getTimePeriod, "19:00-次日9:00")
            );
            if (o.getUpdateTime() == null) { // 如果update_time为空 => 说明是在本时段内才开始停车
                // 直接计算当前时间-create_time作为停车时间
                LocalDateTime createTime = o.getCreateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                Duration duration = Duration.between(createTime, LocalDateTime.now());

                Integer freeHours = charge.getFreeDuration() / 60;
                long parkedHours = duration.toHours();
                long chargeHours = 0;
                if (parkedHours > freeHours) { // 如果停车时限超过免费时间
                    chargeHours = parkedHours - freeHours;
                }
                BigDecimal orderAmount = new BigDecimal(charge.getChargeRate().toString()).multiply(BigDecimal.valueOf(chargeHours));
                orderAmount = orderAmount.min(charge.getMaximumCharge()); // 如果封顶金额更小就赋值为封顶金额
                orderServiceImpl.update(
                        new UpdateWrapper<Order>()
                                .eq("id", o.getId())
                                .set("order_amount", o.getOrderAmount().add(orderAmount))
                );
            } else { // 上个时间段已经开始停车，直接对order amount增加封顶金额
                orderServiceImpl.update(
                        new UpdateWrapper<Order>()
                                .eq("id", o.getId())
                                .set("order_amount", o.getOrderAmount().add(new BigDecimal(charge.getMaximumCharge().toString())))
                                .set("update_time", DateTime.now())
                );
            }
        });
    }

    // 每天晚上19点执行 白天时段结算
    @Scheduled(cron = "0 0 19 * * ?")
    public void eveningTask() {
        // 查找所有进行中订单
        List<Order> ordersInProgress = orderServiceImpl.list(
                new LambdaQueryWrapper<Order>()
                        .eq(Order::getStatus, 6));
        // 判断本时段内的停车时间，并计算本时段的费用，修改update time
        ordersInProgress.forEach(o -> {
            Road road = roadServiceImpl.getOne(
                    new LambdaQueryWrapper<Road>()
                            .eq(Road::getId, o.getRoadId())
            );
            Charge charge = chargeServiceImpl.getOne(
                    new LambdaQueryWrapper<Charge>()
                            .eq(Charge::getCid, road.getChargeId())
                            .eq(Charge::getTimePeriod, "9:00-19:00")
            );
            if (o.getUpdateTime() == null) { // 如果update_time为空 => 说明是在本时段内才开始停车
                // 直接计算当前时间-create_time作为停车时间
                LocalDateTime createTime = o.getCreateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                Duration duration = Duration.between(createTime, LocalDateTime.now());

                Integer freeHours = charge.getFreeDuration() / 60;
                long parkedHours = duration.toHours();
                long chargeHours = 0;
                if (parkedHours > freeHours) { // 如果停车时限超过免费时间
                    chargeHours = parkedHours - freeHours;
                }
                BigDecimal orderAmount = new BigDecimal(charge.getChargeRate().toString()).multiply(BigDecimal.valueOf(chargeHours));
                orderAmount = orderAmount.min(charge.getMaximumCharge()); // 如果封顶金额更小就赋值为封顶金额
                orderServiceImpl.update(
                        new UpdateWrapper<Order>()
                                .eq("id", o.getId())
                                .set("order_amount", o.getOrderAmount().add(orderAmount))
                                .set("update_time",DateTime.now())
                );
            } else { // 上个时间段已经开始停车，直接对order amount增加封顶金额
                orderServiceImpl.update(
                        new UpdateWrapper<Order>()
                                .eq("id", o.getId())
                                .set("order_amount", o.getOrderAmount().add(new BigDecimal(charge.getMaximumCharge().toString())))
                                .set("update_time", DateTime.now())
                );
            }
        });
    }
}
