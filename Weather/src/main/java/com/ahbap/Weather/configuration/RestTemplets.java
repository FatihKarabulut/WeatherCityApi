package com.ahbap.Weather.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration

public class RestTemplets {

    @Bean
    @Scope("prototype")
    public RestTemplate Rest()
    {
      return new RestTemplate();
    }
}
