package pl.aras.accuweather.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class AccuweatherApiStatisticsImpl implements AccuweatherApiStatistics {

    private AtomicLong accuweatherApiCallCounter = new AtomicLong(0);

    @Override
    public void incrementAccuweatherApiCallsCount() {
        accuweatherApiCallCounter.incrementAndGet();
    }

    @Override
    public long getAccuweatherApiCallsCount() {
        return accuweatherApiCallCounter.get();
    }
}
