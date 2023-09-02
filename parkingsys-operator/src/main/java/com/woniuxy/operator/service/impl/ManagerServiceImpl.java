package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.woniuxy.operator.dto.ManagerDTO;
import com.woniuxy.operator.entity.Manager;
import com.woniuxy.operator.mapper.ManagerMapper;
import com.woniuxy.operator.service.IManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {

    private final ManagerMapper managerMapper;

    public ManagerServiceImpl(ManagerMapper managerMapper){
        this.managerMapper = managerMapper;
    }

    @Override
    public Manager login(ManagerDTO managerDTO) {
        return managerMapper.selectOne(Wrappers.lambdaQuery(Manager.class).
                eq(StringUtils.hasLength(managerDTO.getUserCode()),Manager::getAccount,managerDTO.getUserCode()).
                eq(StringUtils.hasLength(managerDTO.getUserPassword()),Manager::getPassword,managerDTO.getUserPassword()));
    }
}
