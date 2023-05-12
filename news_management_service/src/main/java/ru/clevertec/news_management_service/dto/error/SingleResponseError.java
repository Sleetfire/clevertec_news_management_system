package ru.clevertec.news_management_service.dto.error;

public class SingleResponseError {

    private final String logRef;
    private final String message;

    public SingleResponseError(String message) {
        this.message = message;
        this.logRef = "error";
    }

    public String getLogRef() {
        return logRef;
    }

    public String getMessage() {
        return message;
    }
}
