package com.ahbap.Weather.geonames;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherInfo {
    public int elevation;
    public double lng;
    public String observation;
    @JsonProperty("ICAO")
    public String iCAO;
    public String clouds;
    public String dewPoint;
    public String cloudsCode;
    public String datetime;
    public String countryCode;
    public String temperature;
    public int humidity;
    public String stationName;
    public String weatherCondition;
    public int windDirection;
    public int hectoPascAltimeter;
    public String windSpeed;
    public double lat;
}
