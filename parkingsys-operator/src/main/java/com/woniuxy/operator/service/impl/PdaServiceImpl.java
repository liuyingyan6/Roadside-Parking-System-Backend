package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.Pda;
import com.woniuxy.operator.mapper.PdaMapper;
import com.woniuxy.operator.service.IPdaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.PageVO;
import com.woniuxy.operator.vo.PdaVO;
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
public class PdaServiceImpl extends ServiceImpl<PdaMapper, Pda> implements IPdaService {

    private final PdaMapper pdaMapper;

    public PdaServiceImpl(PdaMapper pdaMapper) {
        this.pdaMapper = pdaMapper;
    }

    @Override
    public PageVO getPageByKeyword(Integer pageNum, Integer pageSize, String pdaName, String inspectorName, String roadName) {
        List<PdaVO> list = pdaMapper.selectPageByKeyword(pageNum, pageSize, pdaName, inspectorName, roadName);
        Long total = pdaMapper.selectTotalCount(pdaName, inspectorName, roadName);
        return new PageVO(total, list);
    }
}
