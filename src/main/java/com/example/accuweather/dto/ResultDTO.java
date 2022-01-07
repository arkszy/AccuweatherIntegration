package com.example.accuweather.dto;

import com.example.accuweather.dto.forecast.ForecastDTO;

public class ResultDTO {
    private final boolean success;
    private final ForecastDTO forecast;
    private final String additionalInfo;

    public ResultDTO(boolean success, ForecastDTO forecast) {
        this.success = success;
        this.forecast = forecast;
        this.additionalInfo = null;
    }

    public ResultDTO(boolean success, String additionalInfo) {
        this.success = success;
        this.forecast = null;
        this.additionalInfo = additionalInfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public ForecastDTO getForecast() {
        return forecast;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }
}
