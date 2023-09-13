package com.woniuxy.inspector.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.woniuxy.inspector.entity.MagnetometerLog;
import com.woniuxy.inspector.entity.Order;
import com.woniuxy.inspector.entity.Parking;
import com.woniuxy.inspector.mapper.MagnetometerLogMapper;
import com.woniuxy.inspector.mapper.OrderMapper;
import com.woniuxy.inspector.mapper.ParkingMapper;
import com.woniuxy.inspector.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    private final OrderMapper orderMapper;

    private final ParkingMapper parkingMapper;

    private final MagnetometerLogMapper magnetometerLogMapper;

    public OrderServiceImpl(OrderMapper orderMapper, ParkingMapper parkingMapper, MagnetometerLogMapper magnetometerLogMapper){
        this.orderMapper = orderMapper;
        this.parkingMapper = parkingMapper;
        this.magnetometerLogMapper = magnetometerLogMapper;
    }

    // 增加订单：拿到地磁id去查parking表拿到parking的id和road_id，car_id手动输入，state为1待支付
    // 将parking表中的state改为0有车
    @Override
    public void createOrder(Integer magnetometerId) {
        Parking parking = parkingMapper.selectOne(Wrappers.lambdaQuery(Parking.class)
                .eq(Parking::getMagnetometerId, magnetometerId));

        MagnetometerLog magnetometerLog = magnetometerLogMapper.selectOne(Wrappers.lambdaQuery(MagnetometerLog.class)
                .eq(MagnetometerLog::getMagnetometerId, magnetometerId));

            parking.setStatus(0);
            parkingMapper.updateById(parking);
            Order order = new Order();
            order.setInspectorId(1L);
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setRoadId(parking.getRoadId());
            order.setCarId(666L);
            order.setStatus(0);
            order.setParkingId(parking.getId());
            order.setCreateTime(magnetometerLog.getCreateTime());
            orderMapper.insert(order);
    }
}
