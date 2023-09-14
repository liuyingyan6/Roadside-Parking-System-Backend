package com.woniuxy.user.controller;

import cn.hutool.json.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.woniuxy.user.entity.Order;
import com.woniuxy.user.enums.OrderStatusEnum;
import com.woniuxy.user.pojos.ResponseResult;
import com.woniuxy.user.vo.OrderVO;
import io.swagger.annotations.Api;
import org.apiguardian.api.API;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.woniuxy.user.service.IOrderService;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@RestController
@RequestMapping("/order")
@Api("订单管理")
public class OrderController {

    private final IOrderService orderServiceImpl;

    public OrderController(IOrderService orderServiceImpl1) {
        this.orderServiceImpl = orderServiceImpl1;
    }


    @GetMapping("findByUserId/{userId}/{status}")
    public ResponseResult findByUserId(@PathVariable("userId") Long userId, @PathVariable("status") Integer status) {
        List<OrderVO> orderList = orderServiceImpl.findByUserId(userId, status);
        return ResponseResult.ok(orderList);
    }


    /**
     * 支付订单
     *
     * @param id
     * @return
     */
    public static final String saveURL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    public static final String appId = "9021000123627053";
    public static final String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCSdt+tV69r4sxN8q8gBr8n1uDiKTN4kiDTwQ2IM3ErQidsecFfVe6vBLO6qainhEFm/e4eMQhsXR32tvWjooL4x6RmcwKztoMDbDi6Xv7dpbzmC8vJ1d0lt+gqzZIwc1EeMjXlpgQvif+4g2vo6oYNHWrCDtINpeManCT5nmdEsziokUA21wHCx9eDJuLp6A1cuN99sy5+C2K0E5E5ec17GPzq3dnWzOcYj2iTO3Bhm8F1f0JTsVi5gEz8D5lY1Iw3+0siOF+754/+gR8FlqAS1Nlu+ebIrI78Oh0Z2f8w4e+YgPTa8cPOhabHAxFPBzaMvubxCKyHVsCC+DUAzncZAgMBAAECggEAHLqSf1bewuO2vWdn8HlCT5c3f0UjonfPVpnchKXKgfi08PMk+gVKDyx18JxMx6cKiSAv794gT9koAne60QEUfaXzWmEe249mPWqh6fSuO13CIsGXlJyNh1N+h77Q+Q31kF268rPQyF5iOZgVt5cg+juV8ECl9SVf2Z1dJ1Vp3jCZZ/mWt294L5fLVyL33o3pfw4uG3cD8fSBg0KsTGM5xDTbFMFpfxc0/yRHyomK9+AbsF92rgYB6w+NK8aVvoJSKAGHJ5HdUPEFG0VRb+yT82dB1T94c/SgXtboRvmhOD+TCOrH3gwuACqnGAUvVpcqwGq1XzgGPPL57BP69pYOLQKBgQDE57/YGewIhAtfAk6QkNO1sfhoc4x6NYBbWOBLblIy9+oRdX8GSGeOWRBbXevQEsBC6JtjZlV+hnkmAZGV1d0WJe8awwozhtX+HJDdnPd2vLEqQ1sVX7UvT190ISOoAxX8ZdfB/kaSjyWCKQ/2weWXzwuc+WMo5KJJUZCx2+PuxwKBgQC+a75f6GFAwayKXjAQhTbVTssdsNAHSYy7aEKs3pSr/RtgwyBepgUytFvN7H9KkW4IjDrbIjzi9ddpqldt2k9ew5xn83Z79+y1EMnn99iTx4xFJ+PtUlJvmPQ/bWmlbNR3vRHkpDr0JKhElg7WXmbqXUkRz2Q+2gXg251reX4LHwKBgHvgzVpYnJ2S7VB9tA3Rf9Aswnp8T6HHLRTLKnlqU76LKDCJujuqq7PrppXE1gnW8ixmCPSVOi5azbcyf3RD008O2In+sNlP+Cthr2YtTabe+Zr8Oz6MMwIrroLyImueXWOocwAySBYGhvOHf+qffCFw+f5tC4x7ovn7ncu36oObAoGBAKW4hzpYtyrwYwUY66O1C/+gT01LsABnlj8TgdOI8sKryMPxjZ5RxnxWUv9oL2/qGWT/BcnohizP3+VqBiToteK3QsuFKzzAjBUYw19KaAZUyFL3YHoOBwhwiUEaK7N4f4Cl34ipFVWdAYSPQ+J0zgRxo0IIyCma/TqwZtQ+K9/pAoGATMkFlCFRCApIM+295/B0y8s9xkIHWCZJKDKTWNNvIAU2Iu+hjm8gu8ALzDkCjFNns0uIVUomLgYFsn4iGVchZZdYbbBidYeMaYXJDzjWb11iNh+VZ7hUooviOQXXukA9ZtxrdCe6++zuds3D0dMUgjyWBHPH8PwvIKf+670uhT0=";
    public static final String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlBpH/Mfj2W57lmKg+b9QORQr6Cl5z0ugC//GSPywljr0bGcVYd/3UNQ5JD1BRCvTfvvSrVBoNvTFKHNZl5oD4d7Cu/WA7b90Hwcg2dSbWLcE0hUA3cPVLKFh5Dneeu5AUugkwbMyOhlCMtND9vGtlBO295/d1vch91oEEqWyFrL98Ob+q/h8+s3mVTZSpAwqvbPTwK44mP3c+a6XW/GTDmAUI01gqqFaKHlzLtVHOzmaQA6aK5+kg0tS5Cxbmrh5PV1R0ZkHsuZ0v59Ca+rgRZS43xBtjoPJyGLXS5K7c8bPCHPCFTJBL/toPomXzBYrE4fnvy2OLTOw8G4BA/gzDQIDAQAB";

    @GetMapping("/pay/{id}")
    public void create(@PathVariable("id") String id, HttpServletResponse httpResponse) {
        // 1. 生成订单信息
        Order order = orderServiceImpl.getById(id);
        //支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(saveURL,   // 支付宝网关（固定）。
                appId,     //APPID 即创建应用后生成。
                privateKey,//私钥
                "json", "UTF-8", alipayPublicKey, //公钥
                "RSA2");  //获得初始化的AlipayClient
        //2. 创建 Request并设置Request参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://6grz62.natappfree.cc");       //用户支付完成后的同步跳转页面地址
        alipayRequest.setNotifyUrl("http://6grz62.natappfree.cc//order/notify");   //在公共参数中设置回跳和通知地址
        //发送支付的信息
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", order.getOrderNumber());                   // 订单编号
        bizContent.put("total_amount", order.getOrderAmount());               // 金额
        bizContent.put("subject", "蜗牛精品课程");            // 订单标题
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");       // 固定配置
        alipayRequest.setBizContent(bizContent.toString());
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + "UTF-8");
        try {
            httpResponse.getWriter().write(form); //直接将完整的表单html输出到页面
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PostMapping("/notify")
    @ResponseBody
    public String notify_url(HttpServletRequest request, Model model) throws AlipayApiException {
        System.out.println("request = " + request.getParameter("trade_status"));

        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            System.out.println("=========支付宝异步回调========");
            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
                System.out.println(name + " = " + request.getParameter(name));
            }
            //可以查看 params 中的参数 信息
            String outTradeNo = params.get("out_trade_no");
            String sign = params.get("sign");
            String content = AlipaySignature.getSignCheckContentV1(params);
            boolean checkSignature = AlipaySignature.rsa256CheckContent(content, sign, alipayPublicKey, "UTF-8"); // 验证签名
            // 支付宝验签
            if (checkSignature) {
                // 验签通过
                System.out.println("交易名称: " + params.get("subject"));
                System.out.println("交易状态: " + params.get("trade_status"));
                System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
                System.out.println("商户订单号: " + params.get("out_trade_no"));
                System.out.println("交易金额: " + params.get("total_amount"));
                System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
                System.out.println("买家付款时间: " + params.get("gmt_payment"));
                System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));
                // 查询订单
                Order order = orderServiceImpl.getOne(Wrappers.lambdaQuery(Order.class).eq(Order::getOrderNumber, outTradeNo));
                //修改订单
                if (order != null) {
                    order.setCreateTime(new Date());     //付款时间
                    order.setStatus(OrderStatusEnum.ALREADY_PAY.getCode());             //付款状态
                    orderServiceImpl.updateById(order);    //更新订单
                }
            }
        }
        return "order";
    }
}
