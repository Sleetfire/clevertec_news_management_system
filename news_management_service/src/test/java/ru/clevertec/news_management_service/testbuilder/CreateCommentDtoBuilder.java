package ru.clevertec.news_management_service.testbuilder;

import ru.clevertec.news_management_service.dto.CreateCommentDto;

public class CreateCommentDtoBuilder {

    private String text = "default-comment";
    private String username = "default-username";

    public CreateCommentDtoBuilder() {
    }

    public CreateCommentDtoBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public CreateCommentDtoBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public CreateCommentDto build() {
        return new CreateCommentDto(text, username);
    }
}
