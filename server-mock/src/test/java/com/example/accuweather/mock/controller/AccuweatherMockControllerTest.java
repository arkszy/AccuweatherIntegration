package com.example.accuweather.mock.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AccuweatherMockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldPostalcodesEndpointBeAvailable() throws Exception {
        mockMvc.perform(get("/locations/v1/postalcodes/search?q=PrimaryPostalCode%3A%2002-796"))
                .andExpect(status().isOk());
    }

    @Test
    void whenPrimaryPostalCodeParamIsNotEmptyThenPostalcodesEndpointShouldReturnsCorrectJson() throws Exception {
        mockMvc.perform(get("/locations/v1/postalcodes/search?q=PrimaryPostalCode%3A%2002-796")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("[0].PrimaryPostalCode", equalTo("02-796")))
                .andExpect(jsonPath("[0].AdministrativeArea.ID", equalTo("14")));
    }

    @Test
    void whenPrimaryPostalCodeParamIsEmptyThenPostalcodesEndpointShouldReturnsEmptyArrayJson() throws Exception {
        mockMvc.perform(get("/locations/v1/postalcodes/search")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json("[]"));
    }

    @Test
    void shouldForecastEndpointBeAvailable() throws Exception {
        mockMvc.perform(get("/forecasts/v1/daily/5day/14"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldForecastEndpointBeAvailableAndReturnsCorrectJson() throws Exception {
        mockMvc.perform(get("/forecasts/v1/daily/5day/14")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("DailyForecasts", hasSize(5)))
                .andExpect(jsonPath("DailyForecasts[*].Date", hasSize(5)))
                .andExpect(jsonPath("DailyForecasts[*].Temperature", hasSize(5)))
                .andExpect(jsonPath("DailyForecasts[*].Temperature.Minimum", hasSize(5)))
                .andExpect(jsonPath("DailyForecasts[*].Temperature.Maximum", hasSize(5)))
                .andExpect(jsonPath("DailyForecasts[*].Temperature.Minimum.Value", hasSize(5)))
                .andExpect(jsonPath("DailyForecasts[*].Temperature.Minimum.Unit", hasSize(5)))
                .andExpect(jsonPath("DailyForecasts[*].Temperature.Maximum.Value", hasSize(5)))
                .andExpect(jsonPath("DailyForecasts[*].Temperature.Maximum.Unit", hasSize(5)));
    }
}