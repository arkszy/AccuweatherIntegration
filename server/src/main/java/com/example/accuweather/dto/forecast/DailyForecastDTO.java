package com.example.accuweather.dto.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyForecastDTO {

    @JsonProperty(value = "Date")
    private String date;
    @JsonProperty(value = "Temperature")
    private TemperatureDTO temperature;
}
