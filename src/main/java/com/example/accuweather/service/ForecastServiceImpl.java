package com.example.accuweather.service;

import com.example.accuweather.config.Config;
import com.example.accuweather.dto.forecast.ForecastDTO;
import com.example.accuweather.exception.IntegrationException;
import com.example.accuweather.exception.InternalException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ForecastServiceImpl implements ForecastService {

    private static final String LOCATION_API_NAME = "Forecast API -> forecasts/v1/daily/5day";
    @Value("${accuweather.service.locations.url}")
    private String serviceUrl;
    private final ObjectMapper mapper;
    private final AccuweatherApiStatistics apiStatistics;
    private final AccuweatherService accuweatherService;

    @Override
    public ForecastDTO getFiveDayForecastByLocationKey(String locationKey) throws IntegrationException, InternalException {
        byte[] responseBytes = accuweatherService.getDecodedByteResponseFromGivenUrl(LOCATION_API_NAME, serviceUrl.concat("/").concat(locationKey).concat("?apikey=").concat(Config.API_KEY).concat("&language=pl-PL&metric=true"));
        apiStatistics.incrementAccuweatherApiCallsCount();
        try {
            return mapper.readValue(responseBytes, ForecastDTO.class);
        } catch (IOException e) {
            throw new InternalException(LOCATION_API_NAME, e);
        }
    }
}
