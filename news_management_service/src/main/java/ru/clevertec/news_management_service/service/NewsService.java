package ru.clevertec.news_management_service.service;

import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.CreateNewsDto;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;

import java.util.List;

/**
 * @author Andrey Barkovsky
 * @version 1.0
 */
public interface NewsService {

    /**
     * Method for creating news
     *
     * @param news dto for news creating
     * @return news dto
     */
    NewsDto create(CreateNewsDto news);

    /**
     * Method for finding news by id
     *
     * @param id news id
     * @return news dto
     * @throws EntityNotFoundException when news wasn't found
     */
    NewsDto findById(long id);

    /**
     * Method for finding list of all news
     *
     * @return news list
     * @throws EntityNotFoundException when news weren't found
     */
    List<NewsDto> findAll();

    /**
     * Method for finding page of news
     *
     * @param pageable arg for pagination
     * @return dto page of news
     * @throws EntityNotFoundException when news page wasn't found
     */
    PageDto<NewsDto> findPage(Pageable pageable);

    /**
     * Method for news updating
     *
     * @param id          news id
     * @param updatedNews news dto with updated fields
     * @return updated news dto
     * @throws EntityNotFoundException when news wasn't found
     */
    NewsDto update(long id, CreateNewsDto updatedNews);

    /**
     * Method for deleting news by id
     *
     * @param id news id
     * @throws EntityNotFoundException when news wasn't found
     */
    void deleteById(long id);

    /**
     * Method for finding list of all news by search word part
     *
     * @param wordParts part of search word
     * @return news list
     */
    List<NewsDto> findAllByWordParts(String wordParts);

    /**
     * Method for finding page of news by search word part
     *
     * @param wordParts part of search word
     * @param pageable  arg for pagination
     * @return dto page of news
     */
    PageDto<NewsDto> findPageByWordParts(String wordParts, Pageable pageable);

}
