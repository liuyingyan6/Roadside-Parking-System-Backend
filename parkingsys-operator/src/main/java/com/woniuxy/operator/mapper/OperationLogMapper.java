package com.woniuxy.operator.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.OperationLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLog> {

}
