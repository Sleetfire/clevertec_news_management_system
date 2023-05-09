package ru.clevertec.news_management_service.service;

import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.NewsDto;

public interface CacheFactory {

    Cache<Long, NewsDto> getNewsCache();

    Cache<Long, CommentDto> getCommentCache();

}
