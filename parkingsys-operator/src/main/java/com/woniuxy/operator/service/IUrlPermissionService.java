package com.woniuxy.operator.service;

import com.woniuxy.operator.entity.UrlPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.PermissionMenuVO;

import java.util.List;

/**
 * <p>
 * 菜单和接口权限定义 服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IUrlPermissionService extends IService<UrlPermission> {

    List<PermissionMenuVO> listByManagerId(Long managerId);

    List<PermissionMenuVO> findAll();
}
