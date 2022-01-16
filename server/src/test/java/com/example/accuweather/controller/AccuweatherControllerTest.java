package com.example.accuweather.controller;

import com.example.accuweather.service.AccuweatherApiStatistics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AccuweatherControllerTest {
    @Autowired
    private Environment env;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AccuweatherApiStatistics apiStatistics;

    @Test
    void whenProfileIsProdThenForecastEndpointShouldReturnsCorrectJsonFromAccuweatherAPI() throws Exception {
        String[] activeProfiles = env.getActiveProfiles();
        if (Arrays.asList(activeProfiles).contains("prod")) { //TODO: need change this ugly workaround. Must figure it out why annotations EnableIf and EnableIfSystemProperty not works with spring.profiles.active prop
            assertEquals(0L, apiStatistics.getAccuweatherApiCallsCount());

            mockMvc.perform(get("/5day/forecast/02-796")).andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(jsonPath("forecast.DailyForecasts", hasSize(5)))
                    .andExpect(jsonPath("forecast.DailyForecasts[*].Date", hasSize(5)))
                    .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature", hasSize(5)))
                    .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Minimum", hasSize(5)))
                    .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Maximum", hasSize(5)))
                    .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Minimum.Value", hasSize(5)))
                    .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Minimum.Unit", hasSize(5)))
                    .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Maximum.Value", hasSize(5)))
                    .andExpect(jsonPath("forecast.DailyForecasts[*].Temperature.Maximum.Unit", hasSize(5)));

            assertEquals(2L, apiStatistics.getAccuweatherApiCallsCount());
        }
    }
}
