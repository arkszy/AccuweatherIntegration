package com.example.accuweather.dto.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureDTO {
    @JsonProperty(value = "Minimum")
    private SingleTemperatureDTO minimum;
    @JsonProperty(value = "Maximum")
    private SingleTemperatureDTO maximum;
}
