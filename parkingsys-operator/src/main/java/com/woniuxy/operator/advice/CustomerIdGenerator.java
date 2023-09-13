package com.woniuxy.operator.advice;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

/**
 * 限制雪花id长度
 */
@Component
public class CustomerIdGenerator implements IdentifierGenerator {

    // 序列号
    private long sequence = 0L;
    // 上一次生成ID的时间戳
    private long lastTimestamp = -1L;

    @Override
    public synchronized Long nextId(Object entity) {
        // 获取当前时间戳
        long timestamp = timeGen();
        // 如果当前时间小于上一次生成ID的时间戳，说明系统时钟回退，这是不允许的
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id for "
                    + (lastTimestamp - timestamp) + " milliseconds");
        }

        // 如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) % 1000; // 1000是序列号的最大值
            if (sequence == 0) {
                // 阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            // 时间戳改变，毫秒内序列重置
            sequence = 0L;
        }
        // 上次生成ID的时间截
        lastTimestamp = timestamp;
        // 移位并通过或运算拼到一起组成15位的ID
        return ((timestamp % 1000000) << 10) | sequence;
    }

    // 阻塞到下一个毫秒，直到获得新的时间戳
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    // 返回以毫秒为单位的当前时间
    private long timeGen() {
        return System.currentTimeMillis();
    }
}
