package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.ManagerDTO;
import com.woniuxy.operator.dto.ManagerRoleDTO;
import com.woniuxy.operator.entity.ManagerRole;
import com.woniuxy.operator.handler.Asserts;
import com.woniuxy.operator.handler.BusinessEnum;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.service.IManagerRoleService;
import com.woniuxy.operator.util.TokenUtil;
import com.woniuxy.operator.vo.ManagerVO;
import com.woniuxy.operator.vo.TokenVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    private final IManagerRoleService managerRoleServiceImpl;

    public ManagerController(IManagerService managerServiceImpl, IManagerRoleService managerRoleServiceImpl){
        this.managerServiceImpl = managerServiceImpl;
        this.managerRoleServiceImpl = managerRoleServiceImpl;
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
    public ResponseResult getAll(@Param("pageNum") Integer pageNum,
                                 @Param("pageSize") Integer pageSize,
                                 @Param("account") String account){

        System.out.println("account=============" + account);
        PageInfo<ManagerVO> managerVOS = managerServiceImpl.getAll(pageSize,pageNum,account);
        System.out.println(managerVOS.getList());
        return ResponseResult.ok(managerVOS);
    }

    @DeleteMapping("/delete/{account}")
    public ResponseResult deleteRole(@PathVariable("account") String account){
        System.out.println("account========"+account);
        System.out.println("getClass========"+account.getClass());

        Manager one = managerServiceImpl.getOne(Wrappers.lambdaQuery(Manager.class)
                .eq(Manager::getAccount, account));

        managerRoleServiceImpl.remove(Wrappers.lambdaUpdate(ManagerRole.class)
                .eq(ManagerRole::getManagerId, one.getId()));

        managerServiceImpl.remove(Wrappers.lambdaUpdate(Manager.class)
                .eq(Manager::getAccount,account));

        return ResponseResult.ok();
    }

    @PostMapping("/update")
    public ResponseResult updateManager(@RequestBody ManagerRoleDTO managerRoleDTO){
        System.out.println("managerRoleDTO============="+managerRoleDTO);
        System.out.println("getDepartmentId类型============="+managerRoleDTO.getDepartmentId().getClass());

        managerServiceImpl.update(Wrappers.lambdaUpdate(Manager.class)
                .eq(Manager::getAccount, managerRoleDTO.getAccount())
                .set(Manager::getPassword,managerRoleDTO.getPassword())
                .set(Manager::getTelephone,managerRoleDTO.getTelephone())
                .set(Manager::getDepartmentId,managerRoleDTO.getDepartmentId()));

        Manager one = managerServiceImpl.getOne(Wrappers.lambdaQuery(Manager.class)
                .eq(Manager::getAccount, managerRoleDTO.getAccount()));

        managerRoleServiceImpl.update(Wrappers.lambdaUpdate(ManagerRole.class)
                .eq(ManagerRole::getManagerId, one.getId())
                .set(ManagerRole::getRoleId,managerRoleDTO.getRoleId()));
        return ResponseResult.ok();
    }

    @PostMapping("/add")
    public ResponseResult addManager(@RequestBody ManagerRoleDTO managerRoleDTO){
        System.out.println("managerRoleDTO ==============="+managerRoleDTO);
        System.out.println("getDepartmentId的类型============"+managerRoleDTO.getDepartmentId().getClass());

        Manager manager = new Manager();
        manager.setName(managerRoleDTO.getName());
        manager.setAccount(managerRoleDTO.getAccount());
        manager.setPassword(managerRoleDTO.getPassword());
        manager.setTelephone(managerRoleDTO.getTelephone());
        manager.setDepartmentId(managerRoleDTO.getDepartmentId());
        managerServiceImpl.save(manager);
        Manager one = managerServiceImpl.getOne(Wrappers.lambdaQuery(Manager.class)
                .eq(Manager::getAccount, managerRoleDTO.getAccount()));
        ManagerRole managerRole = new ManagerRole();
        managerRole.setManagerId(one.getId());
        managerRole.setRoleId(managerRoleDTO.getRoleId());
        managerRoleServiceImpl.save(managerRole);
        return ResponseResult.ok();
    }

}
