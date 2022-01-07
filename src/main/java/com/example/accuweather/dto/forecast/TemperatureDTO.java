package com.example.accuweather.dto.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperatureDTO {
    @JsonProperty(value="Minimum")
    private SingleTemperatureDTO minimum;
    @JsonProperty(value="Maximum")
    private SingleTemperatureDTO maximum;

    public SingleTemperatureDTO getMinimum() {
        return minimum;
    }

    public void setMinimum(SingleTemperatureDTO minimum) {
        this.minimum = minimum;
    }

    public SingleTemperatureDTO getMaximum() {
        return maximum;
    }

    public void setMaximum(SingleTemperatureDTO maximum) {
        this.maximum = maximum;
    }
}
