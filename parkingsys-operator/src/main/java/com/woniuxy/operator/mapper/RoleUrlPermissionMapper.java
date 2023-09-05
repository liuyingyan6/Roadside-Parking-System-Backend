package com.woniuxy.operator.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.RoleUrlPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色与菜单、接口权限的对应关系 Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Mapper
public interface RoleUrlPermissionMapper extends BaseMapper<RoleUrlPermission> {

}
