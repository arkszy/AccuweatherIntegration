package com.example.accuweather.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class AccuweatherApiStatisticsImpl implements AccuweatherApiStatistics {

    private final AtomicLong accuweatherApiCallCounter = new AtomicLong(0);

    @Override
    public void incrementAccuweatherApiCallsCount() {
        accuweatherApiCallCounter.incrementAndGet();
    }

    @Override
    public long getAccuweatherApiCallsCount() {
        return accuweatherApiCallCounter.get();
    }
}
