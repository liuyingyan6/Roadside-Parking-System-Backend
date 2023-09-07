package com.woniuxy.operator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.ManagerDTO;
import com.woniuxy.operator.entity.Manager;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.ManagerVO;
import com.woniuxy.operator.vo.PageVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IManagerService extends IService<Manager> {

    Manager login(ManagerDTO managerDTO);


    Page<ManagerVO> getAll(Page<ManagerVO> page,String account);
}
