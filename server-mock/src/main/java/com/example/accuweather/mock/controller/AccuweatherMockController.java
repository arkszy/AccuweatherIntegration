package com.example.accuweather.mock.controller;

import com.example.accuweather.mock.util.JsonResourceLoader;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
public class AccuweatherMockController {

    private static final String JSON_LOCATION_STRING_EXPRESSION = "json/location/location_%s.json";
    private static final String JSON_FORECAST_STRING_EXPRESSION = "json/forecast/forecast_%s.json";
    private static final String PRIMARY_POSTAL_CODE_QUERY_PARAM = "PrimaryPostalCode: ";

    @GetMapping(value = "/locations/v1/postalcodes/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPostalCodes(@RequestParam(required = false, name = "q") String query) {
        if (StringUtils.isNotBlank(query)) {
            try {
                String postalCode = URLDecoder.decode(query, StandardCharsets.UTF_8).substring(query.indexOf(PRIMARY_POSTAL_CODE_QUERY_PARAM) + PRIMARY_POSTAL_CODE_QUERY_PARAM.length()).trim();
                return ResponseEntity.ok(JsonResourceLoader.loadGivenJsonOrReturnEmptyArrayJson(String.format(JSON_LOCATION_STRING_EXPRESSION, postalCode)));
            } catch (Exception e) {
                log.error("UnexpectedError", e);
                return ResponseEntity.internalServerError().body("[]");
            }
        }
        return ResponseEntity.ok("[]");
    }

    @GetMapping(value = "/forecasts/v1/daily/5day/{locationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get5dayForecast(@PathVariable String locationId) {
        try {
            return ResponseEntity.ok(JsonResourceLoader.loadGivenJsonOrReturnEmptyArrayJson(String.format(JSON_FORECAST_STRING_EXPRESSION, locationId)));
        } catch (Exception e) {
            log.error("UnexpectedError", e);
            return ResponseEntity.internalServerError().body("[]");
        }
    }
}
