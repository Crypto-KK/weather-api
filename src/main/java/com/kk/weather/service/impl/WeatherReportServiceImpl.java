package com.kk.weather.service.impl;

import com.kk.weather.common.WeatherResponse;
import com.kk.weather.service.WeatherDataService;
import com.kk.weather.service.WeatherReportService;
import com.kk.weather.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KK
 * 2020/3/14 4:45 下午
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse response = weatherDataService.getDataByCityId(cityId);
        return response.getData();
    }
}
