package com.woniuxy.user.service;

import com.woniuxy.user.dto.UserDTO;
import com.woniuxy.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.user.vo.CarVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
public interface IUserService extends IService<User> {
    List<CarVO> findAll(Long id);
    User login(UserDTO userDTO);
boolean send(Map map,String phone);
}
