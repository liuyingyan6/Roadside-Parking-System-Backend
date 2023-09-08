package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.ParkingDTO;
import com.woniuxy.operator.entity.Parking;
import com.woniuxy.operator.mapper.ParkingMapper;
import com.woniuxy.operator.service.IParkingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.PageVO;
import org.springframework.stereotype.Service;


@Service
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements IParkingService {

    private final ParkingMapper parkingMapper;

    public ParkingServiceImpl(ParkingMapper parkingMapper){
        this.parkingMapper = parkingMapper;
    }

    /**
     * 统计车位数
     */
    @Override
    public int parkingCount(Integer id) {
        QueryWrapper<Parking> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        int count = parkingMapper.selectCount(queryWrapper).intValue();
        return count;
    }

    @Override
    public PageVO<ParkingDTO> findByPage(Integer current, Integer size, ParkingDTO parkingDTO) {
        IPage iPage=new Page<>(current,size);

        String name = parkingDTO.getName();

        IPage<ParkingDTO> page = baseMapper.selectParkDTOPage(iPage, name);

        return PageVO.<ParkingDTO>builder()
                .records(page.getRecords())
                .total(page.getTotal())
                .build();
    }
}
