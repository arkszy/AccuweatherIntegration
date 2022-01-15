package com.example.accuweather.dto.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForecastDTO {

    @JsonProperty(value = "DailyForecasts")
    private DailyForecastDTO[] dailyForecast;
}
