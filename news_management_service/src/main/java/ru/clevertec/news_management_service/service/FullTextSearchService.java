package ru.clevertec.news_management_service.service;

import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.NewsCommentsDtoWrapper;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;

import java.util.List;

public interface FullTextSearchService {

    List<NewsCommentsDtoWrapper> find(String text);

    List<NewsDto> findNewsList(String text);

    List<CommentDto> findCommentList(String text);

    PageDto<NewsDto> findNewsPage(String text, Pageable pageable);

    PageDto<CommentDto> findCommentPage(String text, Pageable pageable);

}
