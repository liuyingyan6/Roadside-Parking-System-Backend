package com.woniuxy.operator.service;

import com.woniuxy.operator.entity.Pda;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.PageVO;
import com.woniuxy.operator.vo.PdaVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IPdaService extends IService<Pda> {

    List<PdaVO> getByKeyword(String pdaName, String inspectorName, String roadName);
}
