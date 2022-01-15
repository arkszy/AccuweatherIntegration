package com.example.accuweather.controller;

import com.example.accuweather.dto.forecast.ForecastResultDTO;
import com.example.accuweather.dto.statistics.StatisticsResultDTO;
import com.example.accuweather.exception.IntegrationException;
import com.example.accuweather.exception.InternalException;
import com.example.accuweather.service.AccuweatherApiStatistics;
import com.example.accuweather.service.ForecastService;
import com.example.accuweather.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccuweatherController {

    private AccuweatherApiStatistics apiStatistics;
    private LocationService locationService;
    private ForecastService forecastService;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @Autowired
    public void setForecastService(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping(value = "/5day/forecast/{postCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ForecastResultDTO> getFiveDayForecastByPostCode(@PathVariable String postCode) {
        try {
            String locationKey = locationService.getLocationKeyByPostCode(postCode);
            if (locationKey != null) {
                return ResponseEntity.ok(ForecastResultDTO.builder().forecast(forecastService.getFiveDayForecastByLocationKey(locationKey)).build());
            } else {
                return ResponseEntity.badRequest().body(ForecastResultDTO.builder().additionalInfo("not exists location id for given postal code").build());
            }
        } catch (IntegrationException e) {
            try {
                return new ResponseEntity<>(ForecastResultDTO.builder().additionalInfo(e.getLocalizedMessage()).build(), HttpStatus.valueOf(e.getResponseCode()));
            } catch (Exception e2) {
                return ResponseEntity.internalServerError().body(ForecastResultDTO.builder().additionalInfo("response code:".concat(String.valueOf(e.getResponseCode())).concat(" ,errorDetails:").concat(e.getLocalizedMessage())).build());
            }
        } catch (InternalException e) {
            return ResponseEntity.internalServerError().body(ForecastResultDTO.builder().additionalInfo(e.getLocalizedMessage()).build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(ForecastResultDTO.builder().additionalInfo("unexpected exception:" + e.getLocalizedMessage()).build());
        }
    }

    @GetMapping(value = "/api/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public StatisticsResultDTO getApiStatistics() {
        return new StatisticsResultDTO(apiStatistics.getAccuweatherApiCallsCount());
    }

    @Autowired
    public void setApiStatistics(AccuweatherApiStatistics apiStatistics) {
        this.apiStatistics = apiStatistics;
    }
}
