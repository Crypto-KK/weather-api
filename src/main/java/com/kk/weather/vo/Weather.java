package com.kk.weather.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KK
 * 2020/3/13 4:41 下午
 */

@Data
public class Weather implements Serializable {
    private static final long serialVersionUID = 1L;
    private String city;
    private String wendu;
    private String ganmao;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
