package com.lenovo.feizai.networkframe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:feizai
 * Date:2021/11/17-0017 下午 02:31:39
 * Describe:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfo {
    private String date;
    private String img;
    private String sun_down_time;
    private String sun_rise_time;
    private String temp_day_c;
    private String temp_day_f;
    private String temp_night_c;
    private String temp_night_f;
    private String wd;
    private String weather;
    private String week;
    private String ws;
}
