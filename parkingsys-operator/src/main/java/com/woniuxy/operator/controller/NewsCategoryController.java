package com.woniuxy.operator.controller;

import com.woniuxy.operator.service.INewsCategoryService;
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
@RequestMapping("/news-category")
public class NewsCategoryController {

    private final INewsCategoryService newsCategoryServiceImpl;

    public NewsCategoryController(INewsCategoryService newsCategoryServiceImpl){
        this.newsCategoryServiceImpl = newsCategoryServiceImpl;
    }

}
