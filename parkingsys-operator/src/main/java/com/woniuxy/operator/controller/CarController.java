package com.woniuxy.operator.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.entity.Car;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.CarOrderVO;
import com.woniuxy.operator.vo.CarVO;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import com.woniuxy.operator.service.ICarService;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/car")
public class CarController {

    private final ICarService carServiceImpl;

    public CarController(ICarService carServiceImpl){
        this.carServiceImpl = carServiceImpl;
    }
    @GetMapping("/carList")
    public ResponseResult getCar(Integer pageSize,Integer pageNum,String key){
        PageHelper.startPage(pageNum,pageSize);
        List<CarVO> list = carServiceImpl.getAll(key);
        PageInfo<CarVO> pageInfo = new PageInfo<>(list);
        return ResponseResult.ok(pageInfo);
    }

    @PostMapping("/delete")
    public ResponseResult geleteCar(String carNumber,Integer userId){

        return null;
    }

    @SneakyThrows
    @GetMapping("/exportExcel")//下载 导出
    public void exportCarList(HttpServletResponse response){
        setExcelRespProp(response,"车辆管理表");
        List<CarVO> carVOList = carServiceImpl.getAll(null);
        EasyExcel.write(response.getOutputStream())
                .head(CarVO.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("停车系统车辆管理列表")
                .doWrite(carVOList);
    }

    private void setExcelRespProp(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
        //contenxt-type=text/html;charset=utf-8
        //contenxt-type=application/json
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(rawFileName, "UTF-8")
                .replaceAll("\\+", "%20");
        response.setHeader("Content-disposition",
                "attachment;filename*=utf-8''" + fileName + ".xlsx");
    }


    @GetMapping("/carOrderList")
    public ResponseResult getCarOrderList(Integer pageSize,Integer pageNum,String carNumber){
        PageHelper.startPage(pageNum,pageSize);
        List<CarOrderVO> carOrderList = carServiceImpl.getCarOrderList(carNumber);
        PageInfo<CarOrderVO> pageInfo = new PageInfo<>(carOrderList);
        return ResponseResult.ok(pageInfo);
    }

    @PostMapping("/lift")
    public ResponseResult lift(@RequestParam Integer carId, @RequestParam Long userId) {
        carServiceImpl.liftCar(carId, userId);
        return ResponseResult.ok();
    }

    @GetMapping("/getCarInfo")
    public ResponseResult getCarInfo(String carNumber){
       Car car = carServiceImpl.getCarInfo(carNumber);
       return ResponseResult.ok(car);
    }
    @GetMapping("/getTime")
    public ResponseResult getTime(@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate) throws ParseException {
        System.out.println("startDate = " + startDate);
        System.out.println("endDate = " + endDate);

        List<String> list = carServiceImpl.getTime(startDate, endDate);
        return ResponseResult.ok(list);
    }


}
