package pl.aras.accuweather.dto.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailyForecastDTO {

    @JsonProperty(value="Date")
    private String date;
    @JsonProperty(value="Temperature")
    private TemperatureDTO temperature;


}
