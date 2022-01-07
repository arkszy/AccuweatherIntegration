package com.example.accuweather.service;

import com.example.accuweather.dto.forecast.ForecastDTO;
import com.example.accuweather.exception.IntegrationException;
import com.example.accuweather.exception.InternalException;

public interface ForecastService {
    ForecastDTO getFiveDayForecastByLocationKey(String locationKey) throws IntegrationException, InternalException;
}
