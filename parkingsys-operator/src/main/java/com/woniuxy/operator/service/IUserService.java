package com.woniuxy.operator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.CarConditionDTO;
import com.woniuxy.operator.dto.OrderRecordDTO;
import com.woniuxy.operator.dto.UserDTO;
import com.woniuxy.operator.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.*;

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

    //账户信息
    AccountVO accountPage(Long id);

    //车辆情况
    PageVO<CarConditionVO> carConditionPage(Integer pageNum, Integer pageSize, Long userId, CarConditionDTO carConditionDTO);

    //订单记录
    PageVO<OrderRecordVO> orderRecordPage(Integer pageNum, Integer pageSize, Long userId, OrderRecordDTO orderRecordDTO);

}
