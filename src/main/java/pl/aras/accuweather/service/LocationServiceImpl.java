package pl.aras.accuweather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.aras.accuweather.config.Config;
import pl.aras.accuweather.dto.locations.LocationDTO;
import pl.aras.accuweather.exception.IntegrationException;
import pl.aras.accuweather.exception.InternalException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class LocationServiceImpl implements LocationService {

    private static Map<String, String> locationKeyByPostCode = new HashMap<>();
    private static final String LOCATION_API_NAME = "Locations API -> locations/v1/search";
    private String serviceUrl;
    private ObjectMapper mapper;
    private AccuweatherApiStatistics apiStatistics;
    private AccuweatherService accuweatherService;

    public LocationServiceImpl(@Value("${accuweather.service.locations.url}") String serviceUrl, ObjectMapper mapper, AccuweatherApiStatistics apiStatistics, AccuweatherService accuweatherService) {
        this.serviceUrl = serviceUrl;
        this.mapper = mapper;
        this.apiStatistics = apiStatistics;
        this.accuweatherService = accuweatherService;
    }

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
