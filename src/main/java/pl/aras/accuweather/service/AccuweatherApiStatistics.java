package pl.aras.accuweather.service;

public interface AccuweatherApiStatistics {
    void incrementAccuweatherApiCallsCount();

    long getAccuweatherApiCallsCount();
}
