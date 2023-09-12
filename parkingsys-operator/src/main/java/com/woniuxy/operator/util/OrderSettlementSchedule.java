package com.woniuxy.operator.util;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class OrderSettlementSchedule {


    // test: 每天晚上8点47分执行
    @Scheduled(cron = "0 47 20 * * ?")
    public void eveningTaskTest() {
        // 执行任务逻辑
        System.out.println("晚上8点30分执行任务");
    }

    // 每天早上7点执行
    @Scheduled(cron = "0 0 7 * * ?")
    public void morningTask() {
        // 执行任务逻辑
        System.out.println("早上7点执行任务");
    }

    // 每天晚上19点执行
    @Scheduled(cron = "0 0 19 * * ?")
    public void eveningTask() {
        // 执行任务逻辑
        System.out.println("晚上19点执行任务");
    }

    // 每周五晚上24:00执行
    @Scheduled(cron = "0 0 0 ? * FRI")
    public void fridayNightTask() {
        // 执行任务逻辑
        System.out.println("周五晚上24:00执行任务");
    }
}
