package com.woniuxy.inspector.config.mp;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        Object createTime = getFieldValByName("createTime", metaObject);
        if (Objects.isNull(createTime)) {
            this.setFieldValByName("createTime",new Date(),metaObject);
        }
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (Objects.isNull(updateTime)) {
            this.setFieldValByName("updateTime",new Date(),metaObject);
        }
    }
}