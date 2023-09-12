package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.common.ResponseResult;

import com.woniuxy.operator.dto.ManagerDTO;
import com.woniuxy.operator.handler.Asserts;
import com.woniuxy.operator.handler.BusinessEnum;
import com.woniuxy.operator.util.TokenUtil;
import com.woniuxy.operator.vo.ManagerVO;
import com.woniuxy.operator.vo.TokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

import com.woniuxy.operator.entity.Manager;
import com.woniuxy.operator.service.IManagerService;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final IManagerService managerServiceImpl;

    public ManagerController(IManagerService managerServiceImpl){
        this.managerServiceImpl = managerServiceImpl;
    }

    @Value("${jwt.signature}")
    private String signature;
    @Value("${jwt.accessTime}")
    private Integer accessTime;
    @Value("${jwt.refreshTime}")
    private Integer refreshTime;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody ManagerDTO managerDTO, HttpServletRequest request){
        //查询数据库，判断是否存在管理员账号，如果不存在，则抛出：用户名或密码错误的异常！
        Manager manager = managerServiceImpl.login(managerDTO);
        Asserts.fail(Objects.isNull(manager), BusinessEnum.ACCOUNT_PASSWORD_ERROR);
        //长短令牌都生成成功
        String accessToken = TokenUtil.createAccessToken(accessTime, manager, signature, request);
        String refreshToken = TokenUtil.createRefreshToken(refreshTime, manager, signature, request);
        return  ResponseResult.ok(new TokenVO(accessToken,refreshToken,manager.getId(),manager.getAccount()));
    }

    @GetMapping("/all")
    public ResponseResult getAll(Integer pageSize,Integer pageNum,String account){
        Page<ManagerVO> page = Page.of(pageNum,pageSize);
        Page<ManagerVO> managerVOS = managerServiceImpl.getAll(page,account);
        return ResponseResult.ok(managerVOS);
    }

}
