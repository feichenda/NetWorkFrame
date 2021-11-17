package com.lenovo.feizai.networkframe.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:feizai
 * Date:2021/11/17-0017 下午 02:36:32
 * Describe:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDetailsInfo {
    private String publishTime;
    private List<Weather3HoursDetailsInfo> weather3HoursDetailsInfos;
}
