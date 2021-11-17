package com.lenovo.feizai.networkframe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:feizai
 * Date:2021/11/17-0017 下午 02:39:14
 * Describe:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Realtime {
    private String img;
    private String sD;
    private String sendibleTemp;
    private String temp;
    private String time;
    private String wD;
    private String wS;
    private String weather;
    private String ziwaixian;
}
