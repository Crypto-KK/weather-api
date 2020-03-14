package com.kk.weather.config;

import com.kk.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by KK
 * 2020/3/14 3:40 下午
 */
@Configuration
public class QuartzConfiguration {
    private final int TIME = 1800;

    @Bean
    public JobDetail weatherDataSyncJobJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();

    }

    @Bean
    public Trigger sampleJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder)
                .build();
    }
}
