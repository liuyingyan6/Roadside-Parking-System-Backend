package com.woniuxy.operator.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;

import cn.hutool.poi.excel.ExcelUtil;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.OrderVO;
import com.woniuxy.operator.vo.PageVO;
import lombok.SneakyThrows;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.service.IOrderService;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 前端控制器
 * </p>
 * 订单表
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderServiceImpl;

    public OrderController(IOrderService orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @GetMapping("/page")
    public ResponseResult page(@Param("pageNum") Integer pageNum,
                               @Param("pageSize") Integer pageSize,
                               @Param("orderDto") OrderDTO orderDto) {
        //封装分页请求对象
        PageVO<OrderDTO> pageVO = orderServiceImpl.findAllPage(pageNum, pageSize, orderDto);
        return ResponseResult.ok(pageVO);
    }

    @PostMapping("/add")
    public ResponseResult add(@RequestBody Order order) {
        orderServiceImpl.save(order);
        return ResponseResult.ok("添加成功");
    }

    /**
     * 导出Excel
     * 参数使用响应对象
     */
    @SneakyThrows
    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) {
        //1.设置响应编码
        response.setCharacterEncoding("utf-8");
        //2.设置响应头 content-disposition：告诉浏览器如何处理当前的资源，是打开inline还是下载attachment
        response.setHeader("content-disposition", "attachment;filename=order.xlsx");
        //3.调用业务层获取所有需要导出的数据
        List<OrderVO> orderVOS = orderServiceImpl.findAll();
        //4.创建导出参数。参数：第一行标题，Sheet工作表名称
        ExportParams exportParams = new ExportParams("订单列表", "订单数据");
        //5.使用导出工具类导出，参数：导出参数，实体类类型，输出数据
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, OrderVO.class, orderVOS);
        //6.将Excel文件写到响应的输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }

    //    public void exportExcel(HttpServletResponse response) {
//        try {
//            // 设置响应编码
//            response.setCharacterEncoding("utf-8");
//            // 设置响应头 content-disposition
//            response.setHeader("content-disposition", "attachment;filename=order.xlsx");
//
//            // 调用业务层获取所有需要导出的数据
//            List<OrderVO> orderVOS = orderServiceImpl.findAll();
//
//            // 创建导出参数
//            ExportParams exportParams = new ExportParams("订单列表", "订单数据");
//
//            // 使用导出工具类导出
//            Workbook workbook = ExcelExportUtil.exportExcel(exportParams, OrderVO.class, orderVOS);
//
//            // 获取输出流
//            try (ServletOutputStream outputStream = response.getOutputStream()) {
//                // 将Excel文件写到响应的输出流中
//                workbook.write(outputStream);
//            }
//
//        } catch (Exception e) {
//            // 处理异常，可以返回错误信息或记录日志
//            e.printStackTrace();
//        }
//    }
    @GetMapping("findAll")
    public ResponseResult findAll() {
        List<OrderVO> all = orderServiceImpl.findAll();
        return ResponseResult.ok(all);
    }

}
