package pl.aras.accuweather.service;

import pl.aras.accuweather.exception.IntegrationException;
import pl.aras.accuweather.exception.InternalException;

public interface LocationService {
    public String getLocationKeyByPostCode(String postCode) throws IntegrationException, InternalException;
}
