package ru.clevertec.news_management_service.service;

import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.CreateCommentDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;

import java.util.List;

/**
 * @author Andrey Barkovsky
 * @version 1.0
 */
public interface CommentService {

    /**
     * Method for creating comment
     *
     * @param newsId  news's id
     * @param comment dto for comment creating
     * @return created comment dto
     */
    CommentDto create(long newsId, CreateCommentDto comment);

    /**
     * Method for finding comment by id
     *
     * @param id comment's id
     * @return comment dto
     * @throws EntityNotFoundException when comment wasn't found
     */
    CommentDto findById(long id);

    /**
     * Method for finding list of all comments
     *
     * @return comment's list
     * @throws EntityNotFoundException when comments weren't found
     */
    List<CommentDto> findAll();

    /**
     * Method for finding page of comment by news id
     *
     * @param newsId   news id
     * @param pageable arg for pagination
     * @return dto page of comments
     * @throws EntityNotFoundException when comment's page wasn't found
     */
    PageDto<CommentDto> findPageByNewsId(long newsId, Pageable pageable);

    /**
     * Method for comment updating
     *
     * @param id             comment's id
     * @param updatedComment comment dto with updated fields
     * @return updated comment dto
     * @throws EntityNotFoundException when comment wasn't found
     */
    CommentDto update(long id, CreateCommentDto updatedComment);

    /**
     * Method for deleting comment by id
     *
     * @param id comment's id
     * @throws EntityNotFoundException when comment wasn't found
     */
    void deleteById(long id);

    /**
     * Method for finding list of comments by news id
     *
     * @param id news id
     * @return comment's list
     * @throws EntityNotFoundException when comments weren't found
     */
    List<CommentDto> findAllByNewsId(long id);

    /**
     * Method for deleting all comments by news id
     *
     * @param newsId news id
     */
    void deleteAllByNewsId(long newsId);

    /**
     * Method for finding comments by part of word
     *
     * @param wordParts part of search word
     * @return comment's list
     */
    List<CommentDto> findAllByWordParts(String wordParts);

    /**
     * Method for finding page of comments by part of word
     *
     * @param wordParts part of search word
     * @param pageable  arg for pagination
     * @return page dto
     */
    PageDto<CommentDto> findPageByWordParts(String wordParts, Pageable pageable);

}
