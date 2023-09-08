package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.Information;
import com.woniuxy.operator.mapper.InformationMapper;
import com.woniuxy.operator.service.IInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-07
 */
@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information> implements IInformationService {

    private final InformationMapper informationMapper;

    public InformationServiceImpl(InformationMapper informationMapper){
        this.informationMapper = informationMapper;
    }

}
