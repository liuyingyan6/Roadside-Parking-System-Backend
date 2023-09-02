package com.woniuxy.operator.service;

import com.woniuxy.operator.dto.ManagerDTO;
import com.woniuxy.operator.entity.Manager;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
public interface IManagerService extends IService<Manager> {

    Manager login(ManagerDTO managerDTO);
}
