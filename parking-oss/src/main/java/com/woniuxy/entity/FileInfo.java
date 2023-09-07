package com.woniuxy.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileInfo{
    private String fileName;
    private String url;
}