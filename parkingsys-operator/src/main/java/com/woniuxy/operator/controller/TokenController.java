package com.woniuxy.operator.controller;

import cn.hutool.core.convert.NumberWithFormat;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;

import com.woniuxy.operator.entity.Manager;
import com.woniuxy.operator.pojos.TokenRequest;
import com.woniuxy.operator.pojos.TokenResponse;
import com.woniuxy.operator.util.TokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RequestMapping("/token")
@RestController
public class TokenController {

    @Value("${jwt.signature}")
    private String signature;
    @Value("${jwt.accessTime}")
    private Integer accessTime;
    /**
     * 通过长令牌置换短令牌
     * @return
     */
    @PostMapping("/refresh")
    public ResponseEntity refresh(@RequestBody TokenRequest request, HttpServletRequest req){
        String refreshToken = request.getRefreshToken();

        //判断长令牌是否为NULL
        if(!StringUtils.hasLength(refreshToken)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();//403
        }

        //判断令牌是否合法
        if(!JWTUtil.verify(refreshToken,signature.getBytes())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();//403
        }

        //判断令牌时间是否超过当前时间，超过，则表示：令牌过期
        JWT jwt = JWTUtil.parseToken(refreshToken);
        String exp = (String) jwt.getPayload("exp");
        LocalDateTime expTime = LocalDateTime.parse(exp,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if(expTime.isBefore(LocalDateTime.now())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();//403
        }

        // 拿到managerId
        NumberWithFormat nwf = (NumberWithFormat) jwt.getPayload("managerId");
        Manager manager = new Manager();
        manager.setId(Long.valueOf(nwf.intValue()));//手动装箱

        //一切正常，置换新的短令牌
        String accessToken = TokenUtil.createAccessToken(accessTime, manager, signature, req);
        return ResponseEntity.ok(new TokenResponse(accessToken));
    }
}
