package com.kk.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by KK
 * 2020/3/13 4:42 下午
 */
@Data
public class Yesterday implements Serializable {
    private static final long serialVersionUID = 1L;
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
