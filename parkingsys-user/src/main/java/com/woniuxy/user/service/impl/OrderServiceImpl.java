package com.woniuxy.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.user.entity.MagnetometerLog;
import com.woniuxy.user.entity.Order;
import com.woniuxy.user.entity.Parking;
import com.woniuxy.user.mapper.MagnetometerLogMapper;
import com.woniuxy.user.mapper.OrderMapper;
import com.woniuxy.user.mapper.ParkingMapper;
import com.woniuxy.user.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.user.vo.OrderVO;
import org.springframework.stereotype.Service;
import com.woniuxy.user.entity.Car;
import com.woniuxy.user.entity.Road;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
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

    @Override
    public List<OrderVO> findOrder(String carNumber) {
        return orderMapper.findOrder(carNumber);
    }

    @Override
    public void createOrder(String parkingNum,Long carId) {
        //通过parkingNum查询路段id,parkingId
        Parking park = parkingMapper.selectOne(Wrappers.lambdaQuery(Parking.class).eq(Parking::getNumber, parkingNum));
        Long roadId = park.getRoadId();
        Long parkingId = park.getId();
        Long magnetometerId = park.getMagnetometerId();
        MagnetometerLog magnetometerLog = magnetometerLogMapper.selectOne(Wrappers.lambdaQuery(MagnetometerLog.class)
                .eq(MagnetometerLog::getMagnetometerId, magnetometerId)
                .orderByAsc(MagnetometerLog::getId)
                .last("LIMIT 1"));
        Date magnetometerLogCreateTime = magnetometerLog.getCreateTime();

        Order order=new Order();
        order.setCarId(carId);
        order.setRoadId(roadId);
        order.setStatus(1);
        order.setParkingId(parkingId);
        order.setCreateTime(magnetometerLogCreateTime);
        orderMapper.insert(order);
    }

    @Override
    public List<OrderVO> findByUserId(Long userId, Integer status) {
        MPJLambdaWrapper<Order> wrapper = new MPJLambdaWrapper<Order>()
                .selectAll(Order.class)
                .select(Car::getCarNumber)
                .selectAs(Parking::getNumber, OrderVO::getParkingNumber)
                .select(Road::getRoadName)
                .leftJoin(Car.class, Car::getId, Order::getCarId)
                .leftJoin(Road.class, Road::getId, Order::getRoadId)
                .leftJoin(Parking.class, Parking::getId, Order::getParkingId)
                .eq(Objects.nonNull(userId), Car::getUserId, userId)
                .eq(Objects.nonNull(status), Order::getStatus, status);

        List<OrderVO> orderVOList = orderMapper.selectJoinList(OrderVO.class, wrapper);
        return orderVOList;
    }
}
