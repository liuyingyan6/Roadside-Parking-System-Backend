package com.woniuxy.inspector.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.inspector.dto.OrderDTO;
import com.woniuxy.inspector.entity.Parking;
import com.woniuxy.inspector.mapper.ParkingMapper;
import com.woniuxy.inspector.service.IParkingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.inspector.vo.OrderVO;
import com.woniuxy.inspector.vo.ParkingVO;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@Service
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements IParkingService {

    private final ParkingMapper parkingMapper;

    public ParkingServiceImpl(ParkingMapper parkingMapper){
        this.parkingMapper = parkingMapper;
    }

    @Override
    public int parkingCount(Integer id) {
        QueryWrapper<Parking> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        int count = parkingMapper.selectCount(queryWrapper).intValue();
        return count;
    }

    @Override
    public PageInfo<OrderVO> findPage(Integer pageNum, Integer pageSize, OrderDTO orderDto) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderVO> orderVOList = parkingMapper.findAllPage(orderDto);
        return new PageInfo<>(orderVOList);
    }

    @Override
    public String getTimeDiff(Date createTime, Date updateTime) {
        long diffInMillies = Math.abs(updateTime.getTime() - createTime.getTime());
        String timeDiff = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(diffInMillies),
                TimeUnit.MILLISECONDS.toMinutes(diffInMillies) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(diffInMillies)),
                TimeUnit.MILLISECONDS.toSeconds(diffInMillies) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diffInMillies)));
        return timeDiff;
    }

    @Override
    public List<ParkingVO> find() {

        return parkingMapper.find();
    }
}
