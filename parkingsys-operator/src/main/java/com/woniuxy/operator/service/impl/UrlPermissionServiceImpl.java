package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.UrlPermission;
import com.woniuxy.operator.mapper.UrlPermissionMapper;
import com.woniuxy.operator.service.IUrlPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.PermissionMenuVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单和接口权限定义 服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
@Service
public class UrlPermissionServiceImpl extends ServiceImpl<UrlPermissionMapper, UrlPermission> implements IUrlPermissionService {

    private final UrlPermissionMapper urlPermissionMapper;

    public UrlPermissionServiceImpl(UrlPermissionMapper urlPermissionMapper){
        this.urlPermissionMapper = urlPermissionMapper;
    }

    @Override
    public List<PermissionMenuVO> listByManagerId(Long managerId) {
        // managerId是前端从localStorage中拿到的当前登陆者的id，也就是admin的id
        List<UrlPermission> permissions = null;
        if(managerId == 1){//查询管理员，直接查询所有的权限数据 (系统默认：id = 1 就是超级管理员)
            permissions  = urlPermissionMapper.selectList(null);
        }else{
            // listByManagerId再xml里写了sql
            permissions = urlPermissionMapper.listByManagerId(managerId);
        }
        return getPermissionMenuVOS(permissions);
    }

    // 授权弹窗：询所有权限
    @Override
    public List<PermissionMenuVO> findAll() {
        List<UrlPermission> permissions = urlPermissionMapper.selectList(null);
        return getPermissionMenuVOS(permissions);//将集合的数据，转换的树形数据
    }

    // 抽取的查找一级菜单二级菜单的方法
    private List<PermissionMenuVO> getPermissionMenuVOS(List<UrlPermission> permissions) {
        //先过滤一级菜单
        List<UrlPermission> finalPermissions = permissions;
        List<PermissionMenuVO> datas = permissions.stream().filter(e -> e.getParentId() == -1).map(e -> {
            PermissionMenuVO pmv = new PermissionMenuVO();
            pmv.setId(e.getId());
            pmv.setName(e.getName());
            //再过滤一次找到二级菜单，并放置到一级菜单中去
            List<PermissionMenuVO> children = finalPermissions.stream().filter(m -> m.getParentId() == e.getId()).map(m -> {
                PermissionMenuVO pmvc = new PermissionMenuVO();
                pmvc.setId(m.getId());
                pmvc.setName(m.getName());
                pmvc.setUrl(m.getUrl());
                return pmvc;
            }).collect(Collectors.toList());
            pmv.setChildren(children);
            return pmv;
        }).collect(Collectors.toList());
        return datas;
    }
}
