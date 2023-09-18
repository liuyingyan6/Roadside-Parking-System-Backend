package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.entity.NewsCategory;
import com.woniuxy.operator.mapper.NewsCategoryMapper;
import com.woniuxy.operator.service.INewsCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-18
 */
@Service
public class NewsCategoryServiceImpl extends ServiceImpl<NewsCategoryMapper, NewsCategory> implements INewsCategoryService {

    private final NewsCategoryMapper newsCategoryMapper;

    public NewsCategoryServiceImpl(NewsCategoryMapper newsCategoryMapper){
        this.newsCategoryMapper = newsCategoryMapper;
    }

}
