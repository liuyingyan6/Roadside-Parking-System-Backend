package com.woniuxy.operator.mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    //分页
    IPage<UserDTO> findAllPage(@Param("page")Page page,@Param("userDTO")UserDTO userDTO);

}
