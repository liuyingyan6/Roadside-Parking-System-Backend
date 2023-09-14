package com.woniuxy.user.mapper;
import com.woniuxy.user.vo.CarVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

List<CarVO>list(Long id);
}
