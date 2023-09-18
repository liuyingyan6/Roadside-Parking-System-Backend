package com.woniuxy.operator.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.NewsDTO;
import com.woniuxy.operator.entity.News;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.service.INewsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-18
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    private final INewsService newsServiceImpl;

    public NewsController(INewsService newsServiceImpl){
        this.newsServiceImpl = newsServiceImpl;
    }

    @PostMapping("/getAll")
    public ResponseResult getAll(@Param("pageNum") Integer pageNum,
                                 @Param("pageSize") Integer pageSize,
                                 @RequestBody NewsDTO newsDTO){
        PageInfo<News> page = newsServiceImpl.getAll(pageNum,pageSize,newsDTO);
        return ResponseResult.ok();
    }
}
