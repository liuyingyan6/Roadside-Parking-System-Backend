package com.woniuxy.operator.controller;

import cn.hutool.core.date.DateTime;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.OperatorDTO;
import com.woniuxy.operator.entity.Magnetometer;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.service.IRoadService;
import com.woniuxy.operator.vo.OperatorVO;
import java.util.List;
import com.woniuxy.operator.entity.Operator;
import com.woniuxy.operator.service.IOperatorService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-10
 */
@RestController
@RequestMapping("/operator")
public class OperatorController {

    private final IOperatorService operatorServiceImpl;

    private final IRoadService roadServiceImpl;

    public OperatorController(IOperatorService operatorServiceImpl, IRoadService roadServiceImpl){
        this.operatorServiceImpl = operatorServiceImpl;
        this.roadServiceImpl = roadServiceImpl;
    }

    @PostMapping("/delete")
    public ResponseResult deleteOperator(@RequestBody OperatorVO operatorVO){
        operatorServiceImpl.deleteOperator(operatorVO);
        return ResponseResult.ok();
    }

    @PutMapping("/disable")
    public ResponseResult disableState(@RequestBody OperatorVO operatorVO){
        Integer num;
        if (operatorVO.getState()!=1){
            operatorVO.setState(1);
            num=1;
        }else {
            operatorVO.setState(0);
            num=0;
        }
        operatorServiceImpl.updateState(operatorVO);
        return ResponseResult.ok(operatorVO.getState());
    }

    @PutMapping("/update")
    public ResponseResult update(@RequestBody OperatorVO operatorVO) {
        operatorServiceImpl.updateOperator(operatorVO);
        return ResponseResult.ok();
    }

    @PostMapping("/add")
    public ResponseResult addOperator(@RequestBody OperatorVO operatorVO){
        System.out.println("operatorVO========"+operatorVO);


        Operator operator = new Operator();
        operator.setOperatorName(operatorVO.getOperatorName());
        operator.setPhone(operatorVO.getPhone());
        operator.setArea(operatorVO.getArea());
        operator.setState(operatorVO.getState());
        String account = operatorVO.getAccount();
        operator.setAccount(account);
        operator.setPassword(operatorVO.getPassword());
        operator.setCreateTime(DateTime.now());
        operatorServiceImpl.save(operator);

        List<String> nameList = operatorVO.getNameList();

        operatorServiceImpl.saveRoad(nameList,account);
        return ResponseResult.ok();
    }

    @PostMapping("/findPage/{pageNum}/{pageSize}")
    public ResponseResult findPage(@PathVariable("pageNum") Integer pageNum,
                                   @PathVariable("pageSize") Integer pageSize,
                                   @RequestBody OperatorDTO operatorDTO){
        System.out.println("operatorDTO============"+operatorDTO);
        PageInfo<OperatorVO> page = operatorServiceImpl.findPage(pageNum,pageSize,operatorDTO);
        return ResponseResult.ok(page);
    }

}
