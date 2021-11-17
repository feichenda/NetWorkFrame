package com.lenovo.feizai.networkframe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:feizai
 * Date:2021/11/17-0017 下午 02:40:25
 * Describe:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pm25 {
    private String advice;
    private String aqi;
    private String citycount;
    private String cityrank;
    private String co;
    private String color;
    private String level;
    private String no2;
    private String o3;
    private String pm10;
    private String pm25;
    private String quality;
    private String so2;
    private String timestamp;
    private String upDateTime;
}
