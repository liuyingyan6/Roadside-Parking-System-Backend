package com.woniuxy.operator.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.MagnetometerVO;
import com.woniuxy.operator.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.operator.entity.Magnetometer;
import com.woniuxy.operator.service.IMagnetometerService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/magnetometer")
public class MagnetometerController {

    private final IMagnetometerService magnetometerServiceImpl;

    public MagnetometerController(IMagnetometerService magnetometerServiceImpl) {
        this.magnetometerServiceImpl = magnetometerServiceImpl;
    }

    @PostMapping("/add")
    public ResponseResult add(@RequestBody Magnetometer magnetometer) {
        magnetometer.setCreateTime(DateTime.now());
        magnetometerServiceImpl.save(magnetometer);
        return ResponseResult.ok();
    }
    @PostMapping("/batchAdd")
    public ResponseResult batchAdd(@RequestBody List<Magnetometer> magnetometers) {
        boolean isSuccess = magnetometerServiceImpl.saveBatch(magnetometers);
        return ResponseResult.ok(isSuccess);
    }

    @DeleteMapping("/delete")
    public ResponseResult delete(Integer id) {
        magnetometerServiceImpl.removeById(id);
        return ResponseResult.ok();
    }

    @GetMapping("/getPageByKeyword")
    public ResponseResult getPageByKeyword(Integer pageNum, Integer pageSize, Integer magnetometerId, String magnetometerName, String roadName) {
        PageVO pageVO = magnetometerServiceImpl.getPageByKeyword(pageNum, pageSize, magnetometerId, magnetometerName, roadName);
        return ResponseResult.ok(pageVO);
    }
    @GetMapping("/getRecordById")
    public ResponseResult getRecordById(Integer id) {

        return ResponseResult.ok();
    }

    @PutMapping("/update")
    public ResponseResult update(@RequestBody Magnetometer magnetometer){
        magnetometerServiceImpl.updateById(magnetometer);
        return ResponseResult.ok();
    }
}
