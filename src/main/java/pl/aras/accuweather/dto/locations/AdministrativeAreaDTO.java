package pl.aras.accuweather.dto.locations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdministrativeAreaDTO {

    @JsonProperty(value = "ID")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
