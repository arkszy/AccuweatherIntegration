package com.example.accuweather.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.example.accuweather.service.AccuweatherApiStatistics;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AccuweatherIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccuweatherApiStatistics apiStatistics;

    @Test
    @Disabled
    void checkIfEndpointIsAvailable() throws Exception {

        assertEquals(apiStatistics.getAccuweatherApiCallsCount(), 0L);

        mockMvc.perform(get("/5day/forecast/02-796")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("success").value("true"))
                .andExpect(jsonPath("forecast.DailyForecasts", hasSize(5)))
                .andExpect(jsonPath("forecast.DailyForecasts[*].Date", hasSize(5)))
                .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature", hasSize(5)))
                .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Minimum", hasSize(5)))
                .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Maximum", hasSize(5)))
                .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Minimum.Value", hasSize(5)))
                .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Minimum.Unit", hasSize(5)))
                .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Maximum.Value", hasSize(5)))
                .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Maximum.Unit", hasSize(5)));

        assertEquals(apiStatistics.getAccuweatherApiCallsCount(), 2L);
    }

}
