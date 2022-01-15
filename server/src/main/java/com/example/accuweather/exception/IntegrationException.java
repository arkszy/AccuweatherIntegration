package com.example.accuweather.exception;

import lombok.Getter;

@Getter
public class IntegrationException extends Exception {
    private final int responseCode;

    public IntegrationException(int responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }
}
