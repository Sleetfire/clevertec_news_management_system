package ru.clevertec.news_management_service.dto;

import lombok.Data;

@Data
public class NewsWrapperDto {

    private NewsDto news;
    private PageDto<CommentDto> comments;

    private NewsWrapperDto(NewsDto news, PageDto<CommentDto> comments) {
        this.news = news;
        this.comments = comments;
    }

    public static NewsWrapperDto of(NewsDto news, PageDto<CommentDto> comments) {
        return new NewsWrapperDto(news, comments);
    }

}
