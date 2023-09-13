package com.woniuxy.operator.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.UserDTO;
import com.woniuxy.operator.entity.Car;
import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.entity.User;
import com.woniuxy.operator.mapper.CarMapper;
import com.woniuxy.operator.mapper.OrderMapper;
import com.woniuxy.operator.mapper.UserMapper;
import com.woniuxy.operator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.PageVO;
import com.woniuxy.operator.vo.UserVO;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;
    private final CarMapper carMapper;
    private final OrderMapper orderMapper;



    public UserServiceImpl(UserMapper userMapper, CarMapper carMapper, OrderMapper orderMapper){
        this.userMapper = userMapper;
        this.carMapper = carMapper;
        this.orderMapper = orderMapper;
    }




    @Override
    public PageVO<UserVO> findPage(Page page, UserDTO userDTO) {
        // 构造查询条件
        String userName = userDTO.getUserName();
        String phone = userDTO.getPhone();
        Integer state = userDTO.getState();
        Integer vx = userDTO.getVx();
        List<User> userList = userMapper.selectList( Wrappers.lambdaQuery(User.class)
                .likeRight(StringUtils.hasLength(userName), User::getUserName, userName)
                .likeRight(StringUtils.hasLength(phone), User::getPhone, phone)
                .eq(Objects.nonNull(state), User::getState, state)
                .eq(Objects.nonNull(vx), User::getVx, vx));

        List<UserVO> collect = userList.stream().map(e -> {
            UserVO userVO = new UserVO();
            BeanUtil.copyProperties(e, userVO);

            List<Car> carList  = carMapper.selectList( Wrappers.lambdaQuery(Car.class)
                    .eq(Objects.nonNull(e.getId()), Car::getUserId, e.getId()));
            userVO.setCarNum((long) carList.size());

            List<Order> orderCount = orderMapper.selectList( Wrappers.lambdaQuery(Order.class)
                    .eq(Objects.nonNull(e.getCarId()), Order::getCarId, e.getCarId()));
            userVO.setOrderNum((long) orderCount.size());

            List<Order> orderList = orderMapper.selectList( Wrappers.lambdaQuery(Order.class)
                    .eq(Objects.nonNull(e.getCarId()), Order::getCarId, e.getCarId())
                    .eq(Objects.nonNull(1), Order::getPayType, 1));
            userVO.setNotOrderNum((long) orderList.size());
            return userVO;
        }).collect(Collectors.toList());

        return  PageVO.<UserVO>builder().records(collect).total((long) collect.size()).build();
    }

    @Override
    public Integer updateState(User user) {
        Integer num;
        if (user.getState()!=1){
            user.setState(1);
            num=1;
        }else {
            user.setState(0);
            num=0;
        }
        return num;
    }


}
