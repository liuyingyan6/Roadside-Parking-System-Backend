// package com.woniuxy.user.listener;
//
// import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
// import com.woniuxy.user.entity.MagnetometerLog;
// import com.woniuxy.user.entity.Order;
// import com.woniuxy.user.entity.Parking;
// import com.woniuxy.user.service.IMagnetometerLogService;
// import com.woniuxy.user.service.IOrderService;
// import com.woniuxy.user.service.IParkingService;
// import org.springframework.amqp.rabbit.annotation.RabbitHandler;
// import org.springframework.amqp.rabbit.annotation.RabbitListener;
// import org.springframework.stereotype.Component;
//
// import java.util.Objects;
//
// @Component
// @RabbitListener(queues = {"car_in_common_queue"})
// public class CarInDeadLetterListener {
//     private final IMagnetometerLogService magnetometerLogServiceImpl;
//     private final IOrderService orderServiceImpl;
//     private final IParkingService parkingServiceImpl;
//
//     public CarInDeadLetterListener(IMagnetometerLogService magnetometerLogServiceImpl, IOrderService orderServiceImpl, IParkingService parkingServiceImpl) {
//         this.magnetometerLogServiceImpl = magnetometerLogServiceImpl;
//         this.orderServiceImpl = orderServiceImpl;
//         this.parkingServiceImpl = parkingServiceImpl;
//     }
//
//     @RabbitHandler
//     public void handler(Integer magnetometerLogId) {
//         // 检验地磁记录表下，同一地磁除了这条驶入记录后，是否还有其他记录
//         MagnetometerLog magnetometerLog = magnetometerLogServiceImpl.getOne(
//                 new LambdaQueryWrapper<MagnetometerLog>()
//                         .eq(MagnetometerLog::getId, magnetometerLogId)); // 获得该记录
//         Integer magnetometerId = magnetometerLog.getMagnetometerId();
//         MagnetometerLog testMagnetometerLog = magnetometerLogServiceImpl.getOne(
//                 new LambdaQueryWrapper<MagnetometerLog>()
//                         .eq(MagnetometerLog::getMagnetometerId, magnetometerId)
//                         .orderByDesc(MagnetometerLog::getId)
//                         .last("LIMIT 1")
//         );
//         if (testMagnetometerLog.getId().equals(magnetometerLogId)) { // 没有驶出记录
//             Parking parking = parkingServiceImpl.getOne(
//                     new LambdaQueryWrapper<Parking>()
//                             .eq(Parking::getMagnetometerId, magnetometerId));
//             Order order = orderServiceImpl.getOne(
//                     new LambdaQueryWrapper<Order>()
//                             .eq(Order::getParkingId, parking.getId())
//                             .eq(Order::getStatus, 6)
//             );
//             if (Objects.isNull(order)){ // 如果没有进行中的订单
//                 System.out.println("发消息给巡检员，车位名为"+parking.getName());
//             }
//         }
//         // 有驶出记录不用管
//     }
// }
