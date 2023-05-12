package ru.clevertec.news_management_service.dto.error;

import java.util.List;

public class MultipleResponseError<T> {

    private final String logRef;
    private final List<T> errors;

    public MultipleResponseError(String logRef, List<T> errors) {
        this.logRef = logRef;
        this.errors = errors;
    }

    public String getLogRef() {
        return logRef;
    }

    public List<T> getErrors() {
        return errors;
    }
}
