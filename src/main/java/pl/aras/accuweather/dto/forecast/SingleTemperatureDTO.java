package pl.aras.accuweather.dto.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SingleTemperatureDTO {

    @JsonProperty(value="Value")
    private double value;
    @JsonProperty(value="Unit")
    private String unit;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
