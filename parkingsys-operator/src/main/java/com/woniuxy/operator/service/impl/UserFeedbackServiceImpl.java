package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.UserDTO;
import com.woniuxy.operator.entity.UserFeedback;
import com.woniuxy.operator.mapper.UserFeedbackMapper;
import com.woniuxy.operator.service.IUserFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.UserFeedbackVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class UserFeedbackServiceImpl extends ServiceImpl<UserFeedbackMapper, UserFeedback> implements IUserFeedbackService {

    private final UserFeedbackMapper userFeedbackMapper;

    public UserFeedbackServiceImpl(UserFeedbackMapper userFeedbackMapper) {
        this.userFeedbackMapper = userFeedbackMapper;
    }

    @Override
    public PageInfo<UserFeedbackVO> findPage(Integer pageNum, Integer pageSize, UserDTO userDTO) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserFeedbackVO> userFeedbackMapperPage = userFeedbackMapper.findPage(userDTO);
        return new PageInfo<>(userFeedbackMapperPage);
    }
}
