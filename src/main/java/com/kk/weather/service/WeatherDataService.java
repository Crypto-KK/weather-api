package com.kk.weather.service;

import com.kk.weather.common.WeatherResponse;

/**
 * Created by KK
 * 2020/3/13 4:46 下午
 */
public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);
}
