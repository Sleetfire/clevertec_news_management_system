package ru.clevertec.news_management_service.service;

import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.NewsDto;

/**
 * @author Andrey Barkovsky
 * @version 1.0
 */
public interface CacheFactory {

    /**
     * Factory method for getting news cache realization
     *
     * @return news cache realization
     */
    Cache<Long, NewsDto> getNewsCache();

    /**
     * Factory method for getting comment cache realization
     *
     * @return comment cache realization
     */
    Cache<Long, CommentDto> getCommentCache();

}
