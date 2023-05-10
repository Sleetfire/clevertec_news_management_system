package ru.clevertec.news_management_service.testbuilder;

import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.NewsDto;

import java.time.LocalDateTime;

public class CommentDtoBuilder {

    private long id = 1L;
    private LocalDateTime time = LocalDateTime.now();
    private String text = "default-text";
    private String username = "default-username";
    private NewsDto news = new NewsDtoBuilder().build();

    public CommentDtoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public CommentDtoBuilder withZeroId() {
        this.id = 0L;
        return this;
    }

    public CommentDtoBuilder withTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public CommentDtoBuilder withNullTime() {
        this.time = null;
        return this;
    }

    public CommentDtoBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public CommentDtoBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public CommentDtoBuilder withNews(NewsDto news) {
        this.news = news;
        return this;
    }

    public CommentDtoBuilder withNullNews() {
        this.news = null;
        return this;
    }

    public CommentDtoBuilder withZeroIdNews() {
        this.news = new NewsDtoBuilder().withZeroId().build();
        return this;
    }

    public CommentDto build() {
        return new CommentDto(id, time, text, username, news);
    }

}
