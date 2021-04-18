package pl.aras.accuweather.exception;

public class IntegrationException extends Exception {
    private int responseCode;

    public IntegrationException(int responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
