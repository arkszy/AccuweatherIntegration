package com.example.accuweather.service;

public interface AccuweatherApiStatistics {
    void incrementAccuweatherApiCallsCount();

    long getAccuweatherApiCallsCount();
}
