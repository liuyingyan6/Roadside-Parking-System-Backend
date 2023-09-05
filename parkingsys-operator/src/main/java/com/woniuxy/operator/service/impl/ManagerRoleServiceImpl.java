package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.ManagerRole;
import com.woniuxy.operator.mapper.ManagerRoleMapper;
import com.woniuxy.operator.service.IManagerRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class ManagerRoleServiceImpl extends ServiceImpl<ManagerRoleMapper, ManagerRole> implements IManagerRoleService {

    private final ManagerRoleMapper managerRoleMapper;

    public ManagerRoleServiceImpl(ManagerRoleMapper managerRoleMapper){
        this.managerRoleMapper = managerRoleMapper;
    }

}
