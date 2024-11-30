package com.ahbap.Weather;

import com.ahbap.Weather.geonames.WeatherSerach;
import com.ahbap.Weather.geonames.WikiSearch;
import com.ahbap.Weather.service.GeoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

@RestController
@RequestMapping("api")
@Slf4j
public class GeoControler {

    public GeoService service;

    public GeoControler(GeoService service) {
        this.service = service;
    }

    @GetMapping("/wikisearch")
    public WikiSearch Wiki(@RequestParam(name = "city") String str, @RequestParam int maxRow)
    {
        try {
            return service.wikiSearch(str,maxRow);
        }
        catch (ResourceAccessException ex)
        {
            log.error("bağlantı sorunu veya sunucuya ulaşılamıyor wikisearch {}",ex.getMessage());
        }
        catch (HttpClientErrorException | HttpServerErrorException ex)
        {
            log.error("istemci hatası wikisearch {}",ex.getMessage());
        }
        catch (Throwable ex)
        {
            log.error("Throwable Exception wikisearch {}",ex.getMessage());
        }

        return null;

    }
    @CrossOrigin(origins = "*")
    @GetMapping("/wiki")
    public WikiSearch Wiki(@RequestParam(name = "city") String str)
    {
        try {
            return service.wikiSearch(str);
        }
        catch (ResourceAccessException ex)
        {
            log.error("bağlantı sorunu veya sunucuya ulaşılamıyor wiki {}",ex.getMessage());
        }
        catch (HttpClientErrorException | HttpServerErrorException ex)
        {
            log.error("istemci hatası wiki {}",ex.getMessage());
        }
        catch (Throwable ex)
        {
            log.error("Throwable Exception wiki {}",ex.getMessage());
        }

        return null;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("weathersearch")
    public WeatherSerach weather(@RequestParam(name = "city") String str)
    {
        try {
            return service.weatherSerach(str);
        }
        catch (ResourceAccessException ex)
        {
            log.error("bağlantı sorunu veya sunucuya ulaşılamıyor weathersearch {}",ex.getMessage());
        }
        catch (HttpClientErrorException | HttpServerErrorException ex)
        {
            log.error("istemci hatası weathersearch {}",ex.getMessage());
        }
        catch (Throwable ex)
        {
            log.error("Throwable Exception weathersearch {}",ex.getMessage());
        }
        return null;
    }

}
