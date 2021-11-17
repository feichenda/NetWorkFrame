package com.lenovo.feizai.networkframe.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:feizai
 * Date:2021/11/17-0017 下午 02:43:42
 * Describe:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Value {
    private String city;
    private String cityid;
    private List<Index> indexes;
    private Pm25 pm25;
    private String provinceName;
    private Realtime realtime;
    private WeatherDetailsInfo weatherDetailsInfo;
    private List<Weather> weathers;
}
