package com.kk.weather.job;

import com.kk.weather.service.CityDataService;
import com.kk.weather.service.WeatherDataService;
import com.kk.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * Created by KK
 * 2020/3/14 3:39 下午
 */

@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {
    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("天气数据同步任务");

        // 读取城市列表
        List<City> cityList = null;
        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            log.error("获取城市异常");
        }

        for (City city: cityList) {
            String cityId = city.getCityId();
            log.info("天气数据同步中，cityid=" + cityId);
            weatherDataService.syncDataByCityId(cityId);
        }

        log.info("天气同步完成");
    }
}
