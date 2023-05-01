package ru.clevertec.news_management_service.service;

import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.CreateCommentDto;
import ru.clevertec.news_management_service.dto.PageDto;

import java.util.List;

public interface CommentService {

    CommentDto create(CreateCommentDto comment);

    CommentDto findById(long id);

    List<CommentDto> findAll();

    PageDto<CommentDto> findPageByNewsId(long newsId, Pageable pageable);

    CommentDto update(long id, CreateCommentDto updatedComment);

    void deleteById(long id);

}
