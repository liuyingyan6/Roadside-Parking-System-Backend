package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.ParkingDTO;
import com.woniuxy.operator.entity.Magnetometer;
import com.woniuxy.operator.entity.Parking;
import com.woniuxy.operator.mapper.MagnetometerMapper;
import com.woniuxy.operator.mapper.ParkingMapper;
import com.woniuxy.operator.service.IParkingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements IParkingService {

    private final ParkingMapper parkingMapper;
    private final MagnetometerMapper magnetometerMapper;

    public ParkingServiceImpl(ParkingMapper parkingMapper, MagnetometerMapper magnetometerMapper) {
        this.parkingMapper = parkingMapper;
        this.magnetometerMapper = magnetometerMapper;
    }


    /**
     * 统计车位数
     */
    @Override
    public int parkingCount(Integer id) {
        QueryWrapper<Parking> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        int count = parkingMapper.selectCount(queryWrapper).intValue();
        return count;
    }

    @Override
    public void updateParkOrMag(ParkingDTO parkingDTO) {
        Parking parking = new Parking();
        Magnetometer magnetometer = new Magnetometer();

        BeanUtils.copyProperties(parkingDTO, parking);
        BeanUtils.copyProperties(parkingDTO, magnetometer);

        magnetometer.setParkingId(parking.getId());
        magnetometer.setName(parkingDTO.getMagnetometerName());

        magnetometerMapper.update(magnetometer, Wrappers.<Magnetometer>lambdaUpdate()
                .eq(Magnetometer::getParkingId, parkingDTO.getId()));

        parking.setMagnetometerId(magnetometer.getId());

        parkingMapper.update(parking, Wrappers.<Parking>lambdaUpdate()
                .eq(Parking::getId, parkingDTO.getId()));
    }

    /**
     * 分页查询
     */
    @Override
    public PageVO<ParkingDTO> findByPage(Integer current, Integer size, ParkingDTO parkingDTO) {
        IPage iPage = new Page<>(current, size);

        String name = parkingDTO.getName();

        IPage<ParkingDTO> page = baseMapper.selectParkDTOPage(iPage, name);

        return PageVO.<ParkingDTO>builder()
                .records(page.getRecords())
                .total(page.getTotal())
                .build();
    }

    @Override
    public void updatePark(ParkingDTO parkingDTO) {
        Parking parking = new Parking();
        // 使用BeanUtils.copyProperties()方法将传入的数据复制到这些对象中
        BeanUtils.copyProperties(parkingDTO, parking);
        parkingMapper.updateById(parking);
        Magnetometer magnetometer = magnetometerMapper.selectById(parking.getMagnetometerId());
        magnetometer.setName(parkingDTO.getMagnetometerName());
        magnetometerMapper.updateById(magnetometer);
    }
}
