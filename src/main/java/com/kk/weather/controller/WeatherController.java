package com.kk.weather.controller;

import com.kk.weather.common.WeatherResponse;
import com.kk.weather.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KK
 * 2020/3/13 4:56 下午
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getByCityId(@PathVariable("cityId") String cityId ) {
        return weatherDataService.getDataByCityId(cityId);
    }
    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getByCityName(@PathVariable("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}
