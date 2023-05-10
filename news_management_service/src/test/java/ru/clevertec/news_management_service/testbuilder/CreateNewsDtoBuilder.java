package ru.clevertec.news_management_service.testbuilder;

import ru.clevertec.news_management_service.dto.CreateNewsDto;

public class CreateNewsDtoBuilder {

    private String title = "default-title";
    private String text = "default-text";

    public CreateNewsDtoBuilder() {
    }

    public CreateNewsDtoBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateNewsDtoBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public CreateNewsDto build() {
        return new CreateNewsDto(title, text);
    }
}
