package com.woniuxy.operator.mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseMapper;
import com.woniuxy.operator.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends MPJBaseMapper<User> {
    //分页
    IPage<UserDTO> findAllPage(@Param("page")Page page,@Param("userDTO")UserDTO userDTO);

    //车辆绑定数
    Integer carNum(Long id);
    //订单数量
    Integer orderNum(Long id);
    //消费金额
    Long expenseMoney(Long id);
    //未交费订单
    Integer notPayOrder(Long id);
    //待缴费金额
    Long notExpenseMoney(Long id);

}
