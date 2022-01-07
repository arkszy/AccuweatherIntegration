package com.example.accuweather.dto.locations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationDTO {

    @JsonProperty(value = "PrimaryPostalCode")
    private String PrimaryPostalCode;
    @JsonProperty(value = "AdministrativeArea")
    private AdministrativeAreaDTO administrativeArea;

    public String getPrimaryPostalCode() {
        return PrimaryPostalCode;
    }

    public void setPrimaryPostalCode(String primaryPostalCode) {
        PrimaryPostalCode = primaryPostalCode;
    }

    public AdministrativeAreaDTO getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(AdministrativeAreaDTO administrativeArea) {
        this.administrativeArea = administrativeArea;
    }
}
