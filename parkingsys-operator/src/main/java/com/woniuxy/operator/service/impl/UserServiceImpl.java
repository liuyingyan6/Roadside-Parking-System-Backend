package com.woniuxy.operator.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.operator.dto.CarConditionDTO;
import com.woniuxy.operator.dto.OrderRecordDTO;
import com.woniuxy.operator.dto.UserDTO;
import com.woniuxy.operator.entity.Car;
import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.entity.User;
import com.woniuxy.operator.enums.OrderStatusEnum;
import com.woniuxy.operator.mapper.CarMapper;
import com.woniuxy.operator.mapper.OrderMapper;
import com.woniuxy.operator.mapper.UserMapper;
import com.woniuxy.operator.service.IUserService;
import com.woniuxy.operator.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.Date;
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




    //用户首页
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

            Long aLong = carMapper.selectCount(Wrappers.lambdaQuery(Car.class)
                    .eq(Objects.nonNull(e.getId()), Car::getUserId, e.getId()));
            userVO.setCarNum(aLong);

            Long aLong1 = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                    .eq(Objects.nonNull(e.getCarId()), Order::getCarId, e.getCarId()));
            userVO.setOrderNum(aLong1);

            Long aLong2 = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                    .eq(Objects.nonNull(e.getCarId()), Order::getCarId, e.getCarId())
                    .eq(Objects.nonNull(1), Order::getPayType, 1));
            userVO.setNotOrderNum(aLong2);
            return userVO;
        }).collect(Collectors.toList());

        return  PageVO.<UserVO>builder().records(collect).total((long) collect.size()).build();
    }

    //用户——账户信息
    @Override
    public AccountVO accountPage(Long id) {
        AccountVO accountVO = new AccountVO();

        Long expenseMoney = userMapper.expenseMoney(id);
        accountVO.setExpenseMoney(expenseMoney);

        Long notExpenseMoney = userMapper.notExpenseMoney(id);
        accountVO.setNotExpenseMoney(notExpenseMoney);

        return accountVO;
    }

    //用户——车辆情况
    public PageVO<CarConditionVO> carConditionPage(Integer pageNum, Integer pageSize, Long userId, CarConditionDTO carConditionDTO){
        Page of = Page.of(pageNum, pageSize);

        String carNum = carConditionDTO.getCarNum();
//        Date startTime = carConditionDTO.getStartTime();
//        Date endTime = carConditionDTO.getEndTime();

        MPJLambdaWrapper<Car> wrapper = new MPJLambdaWrapper<Car>()
                .select(Car::getCarNumber)
                .select(Car::getCarType)
                .eq(Objects.nonNull(userId),Car::getUserId,userId)
                .likeRight(StringUtils.hasLength(carNum),Car::getCarNumber,carNum);
//                .ge(Objects.nonNull(startTime),Car::getCreateTime,startTime)
//                .le(Objects.nonNull(endTime),Car::getCreateTime,endTime);

        Page<CarConditionVO> page = carMapper.selectJoinPage(of, CarConditionVO.class, wrapper);

        page.getRecords().stream().forEach(e->{
            Long orderCount = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                    .eq(Objects.nonNull(e.getId()), Order::getCarId, e.getId()));
            e.setOrderNum(orderCount);

            Long notPayOrder = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                    .eq(Objects.nonNull(e.getId()), Order::getCarId, e.getId())
                    .eq(Order::getStatus, OrderStatusEnum.NO_PAY));
            e.setNotPayOrder(notPayOrder);

            Long expenseMoney = userMapper.expenseMoney(userId);
            e.setExpenseMoney(expenseMoney);

            Long notExpenseMoney = userMapper.notExpenseMoney(userId);
            e.setNotExpenseMoney(notExpenseMoney);

        });

        return PageVO.<CarConditionVO>builder().records(page.getRecords()).total(page.getTotal()).build();
    }


    //用户——订单记录
    @Override
    public PageVO<OrderRecordVO> orderRecordPage(Integer pageNum, Integer pageSize, Long userId, OrderRecordDTO orderRecordDTO) {
        Page of = Page.of(pageNum, pageSize);

        String orderNum = orderRecordDTO.getOrderNumber();
        String carNum = orderRecordDTO.getCarNum();
        Integer status = orderRecordDTO.getStatus();

        MPJLambdaWrapper<Order> wrapper = new MPJLambdaWrapper<Order>()
                .selectAll(Order.class)
                .select(Car::getCarNumber)
                .leftJoin(Car.class,Car::getId,Order::getCarId)
                .eq(Objects.nonNull(userId),Car::getUserId,userId)
                .likeRight(StringUtils.hasLength(orderNum),Order::getOrderNumber,orderNum)
                .likeRight(StringUtils.hasLength(carNum),Car::getCarNumber,carNum)
                .likeRight(Objects.nonNull(status),Order::getStatus,status);

        Page<OrderRecordVO> page = orderMapper.selectJoinPage(of, OrderRecordVO.class, wrapper);



        return PageVO.<OrderRecordVO>builder().records(page.getRecords()).total(page.getTotal()).build();
    }


}
