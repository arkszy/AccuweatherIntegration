package pl.aras.accuweather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.aras.accuweather.config.Config;
import pl.aras.accuweather.dto.forecast.ForecastDTO;
import pl.aras.accuweather.exception.IntegrationException;
import pl.aras.accuweather.exception.InternalException;

import java.io.IOException;

@Service
public class ForecastServiceImpl implements ForecastService {

    private static final String LOCATION_API_NAME = "Forecast API -> forecasts/v1/daily/5day";
    private String serviceUrl;
    private ObjectMapper mapper;
    private AccuweatherApiStatistics apiStatistics;
    private AccuweatherService accuweatherService;

    public ForecastServiceImpl(@Value("${accuweather.service.forecasts.daily.5day.url}") String serviceUrl, ObjectMapper mapper, AccuweatherApiStatistics apiStatistics, AccuweatherService accuweatherService) {
        this.serviceUrl = serviceUrl;
        this.mapper = mapper;
        this.apiStatistics = apiStatistics;
        this.accuweatherService = accuweatherService;
    }

    @Override
    public ForecastDTO getFiveDayForecastByLocationKey(String locationKey) throws IntegrationException, InternalException {
        byte[] responseBytes = accuweatherService.getDecodedByteResponseFromGivenUrl(LOCATION_API_NAME, serviceUrl.concat("/").concat(locationKey).concat("?apikey=").concat(Config.API_KEY).concat("&language=pl-PL&metric=true"));
        apiStatistics.incrementAccuweatherApiCallsCount();
        ForecastDTO forecastDTO = null;
        try {
            return mapper.readValue(responseBytes, ForecastDTO.class);
        } catch (IOException e) {
            throw new InternalException(LOCATION_API_NAME, e);
        }
    }
}
