package com.woniuxy.controller;

import com.aliyun.oss.OSSClient;
import com.woniuxy.common.ResponseResult;
import com.woniuxy.entity.FileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RequestMapping("/oss")
@RestController
public class OSSController {
    @Value("${alibaba.bucket}")
    private String bucket;
    @Resource
    private OSSClient ossClient;
    @PostMapping("/upload")
    public ResponseResult upload(@RequestPart @RequestParam("file") MultipartFile file){
        //获得上传文件的原始名称
        String fileName = file.getOriginalFilename();
        // 上传文件流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            // 桶的名称
            ossClient.putObject(bucket, fileName, inputStream);
            //设置路径10年失效
            LocalDateTime ldt = LocalDateTime.now().plusYears(10);
            Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
            //放入桶中的文件，有效期为10年
            URL url = ossClient.generatePresignedUrl(bucket,fileName, date);
            //封装返回数据
            FileInfo fileInfo = FileInfo.builder().fileName(fileName).url(url.toString()).build();
            return ResponseResult.ok(fileInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseResult.ok();
    }
    /**
     * 删除文件
     * @param fileName 文件的名称
     * @return
     */
    @PostMapping("/delete")
    public ResponseResult delete(String fileName){
        ossClient.deleteObject(bucket,fileName);
        return ResponseResult.ok();
    }
}