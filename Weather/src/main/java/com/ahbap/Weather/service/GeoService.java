package com.ahbap.Weather.service;

import com.ahbap.Weather.geonames.WeatherSerach;
import com.ahbap.Weather.geonames.WikiSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class GeoService {
    private static final String m_Wiki_Url = "http://api.geonames.org/wikipediaSearchJSON?formatted=true&q=%s&maxRows=%d&username=fatihkarabulut";
    private static final String m_Weather_Url = "http://api.geonames.org/findNearByWeatherJSON?formatted=true&lat=%s&lng=%s&username=fatihkarabulut";

    public RestTemplate m_Rest;

    public GeoService(RestTemplate m_Rest) {
        this.m_Rest = m_Rest;
    }

    public WeatherSerach weatherSerach(String str)
    {
        var wiki = wikiSearch(str);
        var url = m_Weather_Url.formatted(wiki.geonames.get(0).lat,wiki.geonames.get(0).lng);
        log.info("weather {}",url);

        return   m_Rest.getForObject(url,WeatherSerach.class);

    }
    public  WikiSearch wikiSearch(String str, int maxRow)
    {
        var url = m_Wiki_Url.formatted(str,maxRow);
        log.info("url = {}",url);
        return m_Rest.getForObject(url,WikiSearch.class);
    }
    public  WikiSearch wikiSearch(String str)
    {
        var url = m_Wiki_Url.formatted(str,10);

        log.info("url = {}",url);
        return m_Rest.getForObject(url,WikiSearch.class);
    }
}
