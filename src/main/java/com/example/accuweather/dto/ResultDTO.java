package com.example.accuweather.dto;

import com.example.accuweather.dto.forecast.ForecastDTO;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResultDTO {
    private ForecastDTO forecast;
    private String additionalInfo;
}
