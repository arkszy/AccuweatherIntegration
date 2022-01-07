package com.example.accuweather.service;

import com.example.accuweather.exception.IntegrationException;
import com.example.accuweather.exception.InternalException;

public interface LocationService {
    String getLocationKeyByPostCode(String postCode) throws IntegrationException, InternalException;
}
