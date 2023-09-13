package com.woniuxy.operator.controller;

import com.woniuxy.operator.dto.RoadDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.entity.User;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.PageVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import com.woniuxy.operator.service.IRoadService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/road")
public class RoadController {
    @Autowired
    private RestTemplate restTemplate;

    private final IRoadService roadServiceImpl;

    public RoadController(IRoadService roadServiceImpl) {
        this.roadServiceImpl = roadServiceImpl;
    }

    /**
     * 分页查询
     */
    @PostMapping("/page/{pageNum}/{pageSize}")
    @ApiOperation("分页查询")
    public ResponseResult findByPage(
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize,
            @RequestBody RoadDTO roadDTO) {
        PageVO<RoadDTO> pageVO = roadServiceImpl.findByPage(pageNum, pageSize, roadDTO);
        return ResponseResult.ok(pageVO);
    }

    /**
     * 新建
     */
    @PostMapping("/add")
    public ResponseResult addRoad(@RequestBody Road road) {
        roadServiceImpl.save(road);
        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除信息")
    public ResponseResult deleteRoad(@PathVariable("id") Long id) {
        roadServiceImpl.removeById(id);
        return ResponseResult.ok();
    }

    /**
     * 禁用功能
     */
    @PutMapping("/update")
    public ResponseResult update(@RequestBody Road road){
        Integer num;
        if (road.getState()!=1){
            road.setState(1);
            num=1;
        }else {
            road.setState(0);
            num=0;
        }
        roadServiceImpl.updateById(road);
        return ResponseResult.ok(road.getState());
    }

    @GetMapping("/list")
    public ResponseResult list(){
        return ResponseResult.ok(roadServiceImpl.list());
    }


    @GetMapping("/getLocation")
    public String getLocation(){
        String key = "cf6cb4245c630692d2f13c1cd1ad1632";
        //后端模拟 浏览器 ，向其他服务器发送HTTP请求
        //HTTP请求协议：请求行  请求头  空行   请求体
        HttpHeaders headers = new HttpHeaders();
        //告诉对方服务器，我传递给他的数据是：表单格式
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //确定走：GET
        String url = "https://restapi.amap.com/v3/weather/weatherInfo?key="+key+"&city=" + "city";
        HttpMethod method = HttpMethod.GET;
        //请求实体对象
        HttpEntity entity = new HttpEntity(headers);
        //发起请求，并得到响应实体对象
        ResponseEntity<String> re =
                restTemplate.exchange(url, method, entity, String.class);
        String body = re.getBody();
        return body;
    }
}
