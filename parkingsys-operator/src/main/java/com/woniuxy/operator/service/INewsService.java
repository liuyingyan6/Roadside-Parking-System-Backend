package com.woniuxy.operator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.NewsDTO;
import com.woniuxy.operator.entity.News;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-18
 */
public interface INewsService extends IService<News> {

    PageInfo<News> getAll(Integer pageNum, Integer pageSize, NewsDTO newsDTO);
}
