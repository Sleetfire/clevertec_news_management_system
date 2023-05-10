package ru.clevertec.news_management_service.testbuilder;

import ru.clevertec.news_management_service.dto.NewsDto;

import java.time.LocalDateTime;

public class NewsDtoBuilder {

    private long id = 1;
    private LocalDateTime time = LocalDateTime.now();
    private String title = "default-title";
    private String text = "default-text";

    public NewsDtoBuilder() {
    }

    public NewsDtoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public NewsDtoBuilder withZeroId() {
        this.id = 0;
        return this;
    }

    public NewsDtoBuilder withTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public NewsDtoBuilder withNullTime() {
        this.time = null;
        return this;
    }

    public NewsDtoBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public NewsDtoBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public NewsDto build() {
        return new NewsDto(id, time, title, text);
    }
}
