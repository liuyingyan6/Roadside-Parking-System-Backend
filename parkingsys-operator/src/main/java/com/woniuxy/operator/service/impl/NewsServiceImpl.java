package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.NewsDTO;
import com.woniuxy.operator.entity.News;
import com.woniuxy.operator.mapper.NewsMapper;
import com.woniuxy.operator.service.INewsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-18
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

    private final NewsMapper newsMapper;

    public NewsServiceImpl(NewsMapper newsMapper){
        this.newsMapper = newsMapper;
    }

    @Override
    public PageInfo<News> getAll(Integer pageNum, Integer pageSize, NewsDTO newsDTO) {
        PageHelper.startPage(pageNum,pageSize);
        List<News> list = newsMapper.getAll(newsDTO);
        return new PageInfo<>(list);
    }
}
