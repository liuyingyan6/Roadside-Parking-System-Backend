package com.woniuxy.operator.controller;

import cn.hutool.core.date.DateTime;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.PageVO;
import com.woniuxy.operator.vo.PdaVO;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.woniuxy.operator.entity.Pda;
import com.woniuxy.operator.service.IPdaService;
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
@RequestMapping("/pda")
public class PdaController {

    private final IPdaService pdaServiceImpl;

    public PdaController(IPdaService pdaServiceImpl) {
        this.pdaServiceImpl = pdaServiceImpl;
    }

    @PostMapping("/add")
    public ResponseResult add(@RequestBody Pda pda) {
        pda.setCreateTime(DateTime.now());
        pdaServiceImpl.save(pda);
        return ResponseResult.ok();
    }

    @SneakyThrows
    @PostMapping("/fileAdd")
    public ResponseResult fileAdd(@RequestPart("file") MultipartFile file) {
        List<Pda> list = EasyExcel.read(file.getInputStream())
                .head(Pda.class)
                .sheet()
                .doReadSync();
        //如果是真实项目，需要对提交上来的数据进行校验
        boolean saved = pdaServiceImpl.saveBatch(list);
        return ResponseResult.ok(saved);
    }

    @DeleteMapping("/delete")
    public ResponseResult delete(Integer id) {
        pdaServiceImpl.removeById(id);
        return ResponseResult.ok();
    }

    @GetMapping("/getPageByKeyword")
    public ResponseResult getPageByKeyword(Integer pageNum, Integer pageSize, String pdaName, String inspectorName, String roadName) {
        PageHelper.startPage(pageNum, pageSize);
        List<PdaVO> list = pdaServiceImpl.getByKeyword(pdaName, inspectorName, roadName);
        PageInfo pageInfo = new PageInfo(list);
        PageVO<PdaVO> pageVO = new PageVO(pageInfo.getTotal(), pageInfo.getList());
        return ResponseResult.ok(pageVO);
    }

    @PutMapping("/update")
    public ResponseResult update(@RequestBody Pda pda) {
        pda.setUpdateTime(DateTime.now());
        pdaServiceImpl.updateById(pda);
        return ResponseResult.ok();
    }


    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        setExcelRespProp(response, "pda信息");
        List<PdaVO> list = pdaServiceImpl.getByKeyword("","","");
        List<String> excludeColumnFiledNames = Arrays.asList("inspectorId"); // 指定要忽略的属性名
        EasyExcel.write(response.getOutputStream())
                .head(PdaVO.class)
                .excludeColumnFiledNames(excludeColumnFiledNames) // 指定要忽略的属性
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("sheet1")
                .doWrite(list);
    }


    @GetMapping("/exportTemplate")
    public void exportTemplate(HttpServletResponse response) throws IOException {
        setExcelRespProp(response, "pda导入模版");
        List<Pda> list = new ArrayList<>(); // 创建一个空的列表作为模板数据
        List<String> excludeColumnFiledNames = Arrays.asList("createTime","updateTime","logicDelete"); // 指定要忽略的属性名
        EasyExcel.write(response.getOutputStream())
                .head(Pda.class)
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
