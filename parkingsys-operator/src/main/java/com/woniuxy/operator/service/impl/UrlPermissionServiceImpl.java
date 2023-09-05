package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.UrlPermission;
import com.woniuxy.operator.mapper.UrlPermissionMapper;
import com.woniuxy.operator.service.IUrlPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 * 菜单和接口权限定义 服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class UrlPermissionServiceImpl extends ServiceImpl<UrlPermissionMapper, UrlPermission> implements IUrlPermissionService {

    private final UrlPermissionMapper urlPermissionMapper;

    public UrlPermissionServiceImpl(UrlPermissionMapper urlPermissionMapper){
        this.urlPermissionMapper = urlPermissionMapper;
    }

}
