package com.example.accuweather.dto.locations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministrativeAreaDTO {

    @JsonProperty(value = "ID")
    private String id;
}
