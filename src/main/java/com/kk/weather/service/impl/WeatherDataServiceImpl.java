package com.kk.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kk.weather.common.WeatherResponse;
import com.kk.weather.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by KK
 * 2020/3/13 4:47 下午
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RestTemplate restTemplate;
    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";
    private final Long TIME_OUT = 1800L;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_API + "?citykey=" + cityId;
        return this.doGetWeatherData(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_API + "?city=" + cityName;
        return this.doGetWeatherData(uri);
    }

    private WeatherResponse doGetWeatherData(String uri) {

        ValueOperations<String, String> operations = this.stringRedisTemplate.opsForValue();
        String key = uri;
        String strBody = null;
        if (!this.stringRedisTemplate.hasKey(key)) {
            log.info("未找到 key:" + key);
            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
            if (response.getStatusCodeValue() == 200) {
                strBody = response.getBody();
            }
            operations.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
        } else {
            log.info("找到key：" + key);
            strBody = operations.get(key);
        }

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }
}
