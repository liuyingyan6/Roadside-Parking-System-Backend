package com.woniuxy.operator.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.UrlPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 菜单和接口权限定义 Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
@Mapper
public interface UrlPermissionMapper extends BaseMapper<UrlPermission> {

}
