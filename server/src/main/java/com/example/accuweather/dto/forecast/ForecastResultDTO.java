package com.example.accuweather.dto.forecast;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ForecastResultDTO {
    private ForecastDTO forecast;
    private String additionalInfo;
}
