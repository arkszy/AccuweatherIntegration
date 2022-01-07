package com.example.accuweather.controller;

import com.example.accuweather.dto.ResultDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.accuweather.exception.IntegrationException;
import com.example.accuweather.exception.InternalException;
import com.example.accuweather.service.AccuweatherApiStatistics;
import com.example.accuweather.service.ForecastService;
import com.example.accuweather.service.LocationService;

@RestController
public class AccuweatherController {

    private AccuweatherApiStatistics apiStatistics;
    private LocationService locationService;
    private ForecastService forecastService;

    @Autowired
    public void setApiStatistics(AccuweatherApiStatistics apiStatistics) {
        this.apiStatistics = apiStatistics;
    }

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @Autowired
    public void setForecastService(ForecastService forecastService) {
        this.forecastService = forecastService;
    }


    @GetMapping(value = "/5day/forecast/{postCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultDTO getFiveDayForecastByPostCode(@PathVariable String postCode) {
        ResultDTO resultDTO;
        try {
            String locationKey = locationService.getLocationKeyByPostCode(postCode);
            if (locationKey != null) {
                return new ResultDTO(true, forecastService.getFiveDayForecastByLocationKey(locationKey));
            } else {
                return new ResultDTO(false, "not exists location id for given postal code");
            }
        } catch (IntegrationException e) {
            return new ResultDTO(false, "response code:".concat(String.valueOf(e.getResponseCode())).concat(" ,errorDetails:" + e.getLocalizedMessage()));
        } catch (InternalException e) {
            return new ResultDTO(false, e.getLocalizedMessage());
        }
    }

    @GetMapping(value = "/api/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getApiStatistics() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode statistics = objectMapper.createObjectNode();
        statistics.put("accuweatherApiCalls", apiStatistics.getAccuweatherApiCallsCount());
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(statistics);
    }
}