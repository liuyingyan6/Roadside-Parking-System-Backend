package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.Argument;
import com.woniuxy.operator.mapper.ArgumentMapper;
import com.woniuxy.operator.service.IArgumentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-08
 */
@Service
public class ArgumentServiceImpl extends ServiceImpl<ArgumentMapper, Argument> implements IArgumentService {

    private final ArgumentMapper argumentMapper;

    public ArgumentServiceImpl(ArgumentMapper argumentMapper){
        this.argumentMapper = argumentMapper;
    }

}
