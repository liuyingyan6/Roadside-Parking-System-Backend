// package com.woniuxy.user.config.mq;
//
// import org.springframework.amqp.core.*;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// @Configuration
// public class CarInDeadLetterModelConfiguration { // 配置死信队列
//
//     @Bean
//     public DirectExchange carInDeadLetterExchange() { // 1、接收MagnetometerLogController的消息，派发给绑定的死信队列
//         return new DirectExchange("car_in_dead_letter_exchange");
//     }
//
//
//     // car_in_dead_letter_exchange交换机与car_in_dead_letter_queue死信队列绑定
//     @Bean
//     public Binding deadLetterBinding() {
//         return BindingBuilder.bind(deadLetterQueue()) // car_in_dead_letter_queue
//                 .to(carInDeadLetterExchange()) // car_in_dead_letter_exchange
//                 .with("dead_routing_key");
//     }
//
//     @Bean
//     public Queue deadLetterQueue() { // 死信队列，完成延迟时间的功能
//         return QueueBuilder.durable("car_in_dead_letter_queue"). // 队列名
//                 deadLetterExchange("car_in_common_exchange"). // 交换机
//                 deadLetterRoutingKey("dead_routing_key"). // 路由key
//                 ttl(1 * 30 * 1000). // 停止时间
//                 build();
//     }
//
//     @Bean
//     public DirectExchange commonExchange() { // car_in_dead_letter_queue死信队列对应时间内未消费的话，会到达普通交换机car_in_common_exchange
//         return new DirectExchange("car_in_common_exchange");
//     }
//
//
//     //完成绑定: 普通队列 & 普通交换机
//     @Bean
//     public Binding commonBinding() {
//         return BindingBuilder
//                 .bind(commonQueue()) // car_in_common_queue
//                 .to(commonExchange()) // car_in_common_exchange
//                 .with("dead_routing_key");
//     }
//
//     @Bean
//     public Queue commonQueue() { // 普通交换机car_in_common_exchange将消息发派给car_in_common_queue队列
//         return new Queue("car_in_common_queue");
//     }
//
// }
//
