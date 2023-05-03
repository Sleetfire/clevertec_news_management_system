package ru.clevertec.news_management_service.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewsCommentsDtoWrapper {

    private NewsDto news;
    private List<CommentDto> comments;

    private NewsCommentsDtoWrapper(NewsDto news, List<CommentDto> comments) {
        this.news = news;
        this.comments = comments;
    }

    public static NewsCommentsDtoWrapper of(NewsDto news, List<CommentDto> comments) {
        return new NewsCommentsDtoWrapper(news, comments);
    }

}
