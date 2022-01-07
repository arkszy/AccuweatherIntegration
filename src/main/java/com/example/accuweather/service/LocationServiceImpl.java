package com.example.accuweather.service;

import com.example.accuweather.config.Config;
import com.example.accuweather.dto.locations.LocationDTO;
import com.example.accuweather.exception.IntegrationException;
import com.example.accuweather.exception.InternalException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private static final Map<String, String> locationKeyByPostCode = new HashMap<>();
    private static final String LOCATION_API_NAME = "Locations API -> locations/v1/search";
    @Value("${accuweather.service.locations.url}")
    private String serviceUrl;
    private final ObjectMapper mapper;
    private final AccuweatherApiStatistics apiStatistics;
    private final AccuweatherService accuweatherService;

    @Override
    public String getLocationKeyByPostCode(String postCode) throws IntegrationException, InternalException {
        String locationKey = locationKeyByPostCode.get(postCode);
        if (locationKey == null) {
            byte[] bytes = accuweatherService.getDecodedByteResponseFromGivenUrl(LOCATION_API_NAME, serviceUrl.concat("?apikey=".concat(Config.API_KEY).concat("&q=PrimaryPostalCode%3A%20").concat(postCode).concat("&offset=1")));
            apiStatistics.incrementAccuweatherApiCallsCount();
            try {
                LocationDTO[] locationArray = mapper.readValue(bytes, LocationDTO[].class);
                if (locationArray != null && locationArray.length > 0) {
                    LocationDTO location = locationArray[0];
                    if (location != null && location.getAdministrativeArea() != null) {
                        locationKeyByPostCode.put(postCode, location.getAdministrativeArea().getId());
                        return location.getAdministrativeArea().getId();
                    }
                }
                return null;
            } catch (IOException e) {
                throw new InternalException(LOCATION_API_NAME, e);
            }
        } else {
            return locationKey;
        }
    }
}