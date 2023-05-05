package ru.clevertec.news_management_service.dto;

import lombok.Data;

@Data
public class NewsCommentsPageWrapperDto {

    private NewsDto news;
    private PageDto<CommentDto> commentsPage;

    private NewsCommentsPageWrapperDto(NewsDto news, PageDto<CommentDto> commentsPage) {
        this.news = news;
        this.commentsPage = commentsPage;
    }

    public static NewsCommentsPageWrapperDto of(NewsDto news, PageDto<CommentDto> commentsPage) {
        return new NewsCommentsPageWrapperDto(news, commentsPage);
    }
}
