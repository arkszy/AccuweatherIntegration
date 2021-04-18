package pl.aras.accuweather.service;

import pl.aras.accuweather.exception.IntegrationException;
import pl.aras.accuweather.exception.InternalException;

public interface AccuweatherService {
    byte[] getDecodedByteResponseFromGivenUrl(String apiInfo, String url) throws InternalException, IntegrationException;
}
