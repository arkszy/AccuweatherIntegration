package com.example.accuweather.exception;

public class IntegrationException extends Exception {
    private final int responseCode;

    public IntegrationException(int responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }
}
