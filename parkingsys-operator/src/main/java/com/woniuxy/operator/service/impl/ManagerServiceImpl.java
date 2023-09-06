package com.woniuxy.operator.service.impl;

import cn.hutool.db.sql.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.ManagerDTO;
import com.woniuxy.operator.entity.Manager;
import com.woniuxy.operator.entity.UrlPermission;
import com.woniuxy.operator.mapper.ManagerMapper;
import com.woniuxy.operator.service.IManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.ManagerVO;
import com.woniuxy.operator.vo.PageVO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {

    private final ManagerMapper managerMapper;

    public ManagerServiceImpl(ManagerMapper managerMapper){
        this.managerMapper = managerMapper;
    }

    @Override
    public Manager login(ManagerDTO managerDTO) {
        return managerMapper.selectOne(Wrappers.lambdaQuery(Manager.class).
                eq(StringUtils.hasLength(managerDTO.getUserCode()),Manager::getAccount,managerDTO.getUserCode()).
                eq(StringUtils.hasLength(managerDTO.getUserPassword()),Manager::getPassword,managerDTO.getUserPassword()));
    }

    @Override
    public Page<ManagerVO> getAll(Page<ManagerVO> page,String account) {
        List<ManagerVO> list = managerMapper.getAll();
        page.setRecords(list);
        page.setTotal(list.size());
        return page;
    }
}
