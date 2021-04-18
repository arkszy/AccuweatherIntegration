package pl.aras.accuweather.service;

import pl.aras.accuweather.dto.forecast.ForecastDTO;
import pl.aras.accuweather.exception.IntegrationException;
import pl.aras.accuweather.exception.InternalException;

public interface ForecastService {
    ForecastDTO getFiveDayForecastByLocationKey(String locationKey) throws IntegrationException, InternalException;
}
