package com.lenovo.feizai.networkframe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:feizai
 * Date:2021/11/17-0017 下午 02:37:09
 * Describe:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather3HoursDetailsInfo {
    private String endTime;
    private String highestTemperature;
    private String img;
    private String isRainFall;
    private String lowerestTemperature;
    private String precipitation;
    private String startTime;
    private String wd;
    private String weather;
    private String ws;
}
