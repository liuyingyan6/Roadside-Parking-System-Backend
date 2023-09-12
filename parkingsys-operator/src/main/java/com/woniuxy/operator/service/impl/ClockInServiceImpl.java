package com.woniuxy.operator.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.ClockInDTO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.woniuxy.operator.entity.ClockIn;
import com.woniuxy.operator.mapper.ClockInMapper;
import com.woniuxy.operator.service.IClockInService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.ClockInVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.YearMonth;
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
public class ClockInServiceImpl extends ServiceImpl<ClockInMapper, ClockIn> implements IClockInService {

    private final ClockInMapper clockInMapper;

    public ClockInServiceImpl(ClockInMapper clockInMapper){
        this.clockInMapper = clockInMapper;
    }

    @Override
    public PageInfo<ClockInVO> findPage(Integer pageNum, Integer pageSize, ClockInDTO clockInDTO) {
        PageHelper.startPage(pageNum,pageSize);
        List<ClockInVO>clockInVOList=clockInMapper.findAllPage(clockInDTO);
        return new PageInfo<>(clockInVOList);
    }
    @Override
    public List<ClockIn> findByInspetorId(String inspectorId, String month) {
        YearMonth yearMonth;
        // 如果month参数为空，则使用当前月份
        if (month == null || month.isEmpty()) {
            yearMonth = YearMonth.now();
        } else {
            yearMonth = YearMonth.parse(month); // 解析传入的月份字符串
        }
        LocalDate firstDayOfMonth = yearMonth.atDay(1); // 该月份的第一天
        LocalDate lastDayOfMonth = yearMonth.atEndOfMonth(); // 该月份的最后一天

        // 在查询时添加日期范围的条件
        List<ClockIn> clockInList = clockInMapper.selectList(Wrappers.lambdaQuery(ClockIn.class)
                .eq(StringUtils.hasLength(inspectorId), ClockIn::getInspectorId, inspectorId)
                .ge(ClockIn::getCreateTime, firstDayOfMonth)
                .le(ClockIn::getCreateTime, lastDayOfMonth));
        return clockInList;
    }

    @Override
    public ClockInVO findByInspectorIdCount(String inspectorId, String month) {
        YearMonth yearMonth;
        // 如果month参数为空，则使用当前月份
        if (month == null || month.isEmpty()) {
            yearMonth = YearMonth.now();
        } else {
            yearMonth = YearMonth.parse(month); // 解析传入的月份字符串
        }
        LocalDate firstDayOfMonth = yearMonth.atDay(1); // 该月份的第一天
        LocalDate lastDayOfMonth = yearMonth.atEndOfMonth(); // 该月份的最后一天

        ClockInVO clockInVO = new ClockInVO();
        // 在查询时添加日期范围的条件
        Long normalWorkingCount = clockInMapper.selectCount(Wrappers.lambdaQuery(ClockIn.class)
                .eq(StringUtils.hasLength(inspectorId), ClockIn::getInspectorId, inspectorId)
                .ge(ClockIn::getCreateTime, firstDayOfMonth)
                .le(ClockIn::getCreateTime, lastDayOfMonth)
                .eq(ClockIn::getClockInStatus, 1));
        clockInVO.setNormalWorkingCount(normalWorkingCount);
        clockInVO.setAttendanceDayCount(normalWorkingCount);

        Long abnormalWorkCount = clockInMapper.selectCount(Wrappers.lambdaQuery(ClockIn.class)
                .eq(StringUtils.hasLength(inspectorId), ClockIn::getInspectorId, inspectorId)
                .ge(ClockIn::getCreateTime, firstDayOfMonth)
                .le(ClockIn::getCreateTime, lastDayOfMonth)
                .eq(ClockIn::getClockInStatus, 0));
        clockInVO.setAbnormalWorkCount(abnormalWorkCount);


        return clockInVO;
    }
}
