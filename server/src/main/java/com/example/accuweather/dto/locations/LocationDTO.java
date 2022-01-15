package com.example.accuweather.dto.locations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {

    @JsonProperty(value = "PrimaryPostalCode")
    private String primaryPostalCode;
    @JsonProperty(value = "AdministrativeArea")
    private AdministrativeAreaDTO administrativeArea;
}
