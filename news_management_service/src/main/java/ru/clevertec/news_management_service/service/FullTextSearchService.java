package ru.clevertec.news_management_service.service;

import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.NewsCommentsDtoWrapper;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;

import java.util.List;

/**
 * @author Andrey Barkovsky
 * @version 1.0
 */
public interface FullTextSearchService {

    /**
     * Method for finding wrapper (single news and list of comments) by part of search word
     *
     * @param text part of search word
     * @return dto with single news and list of comments
     * @throws EntityNotFoundException when news or comments weren't found
     */
    List<NewsCommentsDtoWrapper> find(String text);

    /**
     * Method for finding list of all news by search word part
     *
     * @param text part of search word
     * @return news list
     */
    List<NewsDto> findNewsList(String text);

    /**
     * Method for finding comments by part of word
     *
     * @param text part of search word
     * @return comment's list
     */
    List<CommentDto> findCommentList(String text);

    /**
     * Method for finding page of news by search word part
     *
     * @param text     part of search word
     * @param pageable arg for pagination
     * @return dto page of news
     */
    PageDto<NewsDto> findNewsPage(String text, Pageable pageable);

    /**
     * Method for finding page of comments by part of word
     *
     * @param text     part of search word
     * @param pageable arg for pagination
     * @return page dto
     */
    PageDto<CommentDto> findCommentPage(String text, Pageable pageable);

}
