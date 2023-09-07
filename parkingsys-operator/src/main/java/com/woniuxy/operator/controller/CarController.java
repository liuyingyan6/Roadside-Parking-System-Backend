package com.woniuxy.operator.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.CarVO;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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



}
