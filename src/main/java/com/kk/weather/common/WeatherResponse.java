package com.kk.weather.common;

import com.kk.weather.vo.Weather;

import java.io.Serializable;

/**
 * Created by KK
 * 2020/3/13 4:45 下午
 */
public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Weather data;
    private String status;
    private String desc;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
