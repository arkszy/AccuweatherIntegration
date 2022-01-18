package com.example.accuweather.mock.util;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.experimental.UtilityClass;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@UtilityClass
public class JsonResourceLoader {
    public String loadGivenJsonOrReturnEmptyArrayJson(String path) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(path);
        try (InputStream inputStream = classPathResource.getInputStream()) {
            String file = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            if (StringUtils.isNotBlank(file)) {
                return file;
            } else {
                return "[]";
            }
        }
    }
}
