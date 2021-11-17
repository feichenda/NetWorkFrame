package com.lenovo.feizai.networkframe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:feizai
 * Date:2021/11/17-0017 下午 02:42:20
 * Describe:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Index {
    private String abbreviation;
    private String alias;
    private String content;
    private String level;
    private String name;
}
