package ru.clevertec.news_management_service.service;

import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.CreateCommentDto;
import ru.clevertec.news_management_service.dto.PageDto;

import java.util.List;

public interface CommentService {

    CommentDto create(long newsId, CreateCommentDto comment);

    CommentDto findById(long id);

    List<CommentDto> findAll();

    PageDto<CommentDto> findPageByNewsId(long newsId, Pageable pageable);

    CommentDto update(long id, CreateCommentDto updatedComment);

    void deleteById(long id);

    List<CommentDto> findAllByNewsId(long id);

    void deleteAllByNewsId(long newsId);

    List<CommentDto> findAllByWordParts(String wordParts);

    PageDto<CommentDto> findPageByWordParts(String wordParts, Pageable pageable);

}
