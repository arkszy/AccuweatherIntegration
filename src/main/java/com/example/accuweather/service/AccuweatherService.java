package com.example.accuweather.service;

import com.example.accuweather.exception.IntegrationException;
import com.example.accuweather.exception.InternalException;

public interface AccuweatherService {
    byte[] getDecodedByteResponseFromGivenUrl(String apiInfo, String url) throws InternalException, IntegrationException;
}
