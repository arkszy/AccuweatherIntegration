package com.example.accuweather.mock.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@UtilityClass
public class JsonResourceLoader {
    public String loadGivenJsonOrReturnEmptyJson(String path) throws IOException {
        InputStream resource = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
        if (resource == null) {
            return "[]";
        } else {
            return new String(resource.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
