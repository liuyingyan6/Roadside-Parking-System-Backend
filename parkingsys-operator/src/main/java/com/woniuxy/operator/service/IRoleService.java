package com.woniuxy.operator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IRoleService extends IService<Role> {

    PageVO<Role> findAll2Page(Page<Role> page, String name);

    void deleteRole(Long id);
}
