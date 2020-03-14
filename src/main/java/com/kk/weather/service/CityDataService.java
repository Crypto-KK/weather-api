package com.kk.weather.service;

import com.kk.weather.vo.City;

import java.util.List;

public interface CityDataService {
    /**
     * 获取城市列表
     */
    List<City> listCity() throws Exception;
}
