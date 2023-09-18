package com.woniuxy.operator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.operator.dto.NewsDTO;
import com.woniuxy.operator.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-18
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {

    List<News> getAll(@Param("newsDTO") NewsDTO newsDTO);
}

