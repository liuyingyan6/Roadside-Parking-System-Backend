package com.woniuxy.operator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.UserDTO;
import com.woniuxy.operator.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.PageVO;
import com.woniuxy.operator.vo.UserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IUserService extends IService<User> {

    PageVO<UserVO> findPage(Page<User> page, UserDTO userDTO);

    Integer updateState(User user);

    Long selectById(Long id);
}
