package com.kk.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by KK
 * 2020/3/13 4:43 下午
 */
@Data
public class Forecast implements Serializable {
    private static final long serialVersionUID = 1L;
    private String date;
    private String high;
    private String fengxiang;
    private String low;
    private String fengli;
    private String type;
}
