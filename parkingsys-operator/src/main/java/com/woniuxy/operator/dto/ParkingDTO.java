package com.woniuxy.operator.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.woniuxy.operator.entity.Parking;
import com.woniuxy.operator.entity.Road;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingDTO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String number;
    private String name;
    private Integer status;

    private Road road;
    private Long roadId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long magnetometerId;
    private String magnetometerName;
    private Date magnetometerTime;

    private Date createTime;
}
