package com.kk.weather.service.impl;

import com.kk.weather.service.CityDataService;
import com.kk.weather.util.XmlBuilder;
import com.kk.weather.vo.City;
import com.kk.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by KK
 * 2020/3/14 4:21 下午
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), "utf-8")
        );
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }
        bufferedReader.close();

        // XML -> JAVA POJO
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, stringBuffer.toString());
        return cityList.getCityList();
    }
}
