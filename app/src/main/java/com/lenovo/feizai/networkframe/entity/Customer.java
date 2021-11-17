package com.lenovo.feizai.networkframe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:feizai
 * Date:2021/11/17-0017 上午 10:07:16
 * Describe: 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String username;
    private String phone;
    private String QQ;
    private String company;
    private double company_longitude;
    private double company_latitude;
    private String home;
    private double home_longitude;
    private double home_latitude;
    private String avatar;
}
