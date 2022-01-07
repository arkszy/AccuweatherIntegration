package com.example.accuweather.dto.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForecastDTO {

    @JsonProperty(value="DailyForecasts")
    private DailyForecastDTO[] dailyForecast;

    public DailyForecastDTO[] getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(DailyForecastDTO[] dailyForecast) {
        this.dailyForecast = dailyForecast;
    }
}
