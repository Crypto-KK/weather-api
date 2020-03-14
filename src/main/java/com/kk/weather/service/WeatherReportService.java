package com.kk.weather.service;

import com.kk.weather.vo.Weather;

public interface WeatherReportService {

    /**
     * 根据id查询
     */
    Weather getDataByCityId(String cityId);
}
