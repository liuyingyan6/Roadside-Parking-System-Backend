package com.woniuxy.operator.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.annotation.SaveOperationLog;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.MagnetometerVO;
import com.woniuxy.operator.vo.PageVO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.woniuxy.operator.entity.Magnetometer;
import com.woniuxy.operator.service.IMagnetometerService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

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

    @SaveOperationLog(description = "添加地磁")
    @PostMapping("/add")
    public ResponseResult add(@RequestBody Magnetometer magnetometer) {
        magnetometer.setCreateTime(DateTime.now());
        magnetometerServiceImpl.save(magnetometer);
        return ResponseResult.ok();
    }

    @SaveOperationLog(description = "批量添加地磁")
    @SneakyThrows
    @PostMapping("/fileAdd")
    public ResponseResult fileAdd(@RequestPart("file") MultipartFile file) {
        List<Magnetometer> list = EasyExcel.read(file.getInputStream())
                .head(Magnetometer.class)
                .sheet()
                .doReadSync();
        //如果是真实项目，需要对提交上来的数据进行校验
        boolean saved = magnetometerServiceImpl.saveBatch(list);
        return ResponseResult.ok(saved);
    }

    @SaveOperationLog(description = "删除地磁")
    @DeleteMapping("/delete")
    public ResponseResult delete(Integer id) {
        magnetometerServiceImpl.removeById(id);
        return ResponseResult.ok();
    }

    @GetMapping("/getPageByKeyword")
    public ResponseResult getPageByKeyword(Integer pageNum, Integer pageSize, String magnetometerName, String roadName) {
        PageHelper.startPage(pageNum, pageSize);
        List<MagnetometerVO> list = magnetometerServiceImpl.getByKeyword(magnetometerName, roadName);
        PageInfo pageInfo = new PageInfo(list);
        PageVO<MagnetometerVO> pageVO = new PageVO<MagnetometerVO>(pageInfo.getTotal(), pageInfo.getList());
        return ResponseResult.ok(pageVO);
    }

    @GetMapping("/getRecordById")
    public ResponseResult getRecordById(Integer id) {
        return ResponseResult.ok();
    }

    @SaveOperationLog(description = "修改地磁")
    @PutMapping("/update")
    public ResponseResult update(@RequestBody Magnetometer magnetometer) {
        magnetometer.setUpdateTime(DateTime.now());
        magnetometerServiceImpl.updateById(magnetometer);
        return ResponseResult.ok();
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        setExcelRespProp(response, "地磁信息");
        List<MagnetometerVO> list = magnetometerServiceImpl.getByKeyword("", "");
        List<String> excludeColumnFiledNames = Arrays.asList("parkingId"); // 指定要忽略的属性名
        EasyExcel.write(response.getOutputStream())
                .head(MagnetometerVO.class)
                .excludeColumnFiledNames(excludeColumnFiledNames) // 指定要忽略的属性
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("sheet1")
                .doWrite(list);
    }

    @GetMapping("/exportTemplate")
    public void exportTemplate(HttpServletResponse response) throws IOException {
        setExcelRespProp(response, "地磁导入模版");
        List<Magnetometer> list = new ArrayList<>(); // 创建一个空的列表作为模板数据
        List<String> excludeColumnFiledNames = Arrays.asList("createTime", "updateTime", "logicDelete"); // 指定要忽略的属性名
        EasyExcel.write(response.getOutputStream())
                .head(Magnetometer.class)
                .excludeColumnFiledNames(excludeColumnFiledNames) // 指定要忽略的属性
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("sheet1")
                .doWrite(list);
    }

    /**
     * 设置excel下载响应头属性
     */
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
