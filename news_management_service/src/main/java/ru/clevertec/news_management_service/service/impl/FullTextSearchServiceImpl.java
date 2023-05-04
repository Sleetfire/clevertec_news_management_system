package ru.clevertec.news_management_service.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.NewsCommentsDtoWrapper;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;
import ru.clevertec.news_management_service.service.CommentService;
import ru.clevertec.news_management_service.service.FullTextSearchService;
import ru.clevertec.news_management_service.service.NewsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class FullTextSearchServiceImpl implements FullTextSearchService {

    private final NewsService newsServiceImpl;
    private final CommentService commentServiceImpl;

    public FullTextSearchServiceImpl(NewsService newsServiceImpl, CommentService commentServiceImpl) {
        this.newsServiceImpl = newsServiceImpl;
        this.commentServiceImpl = commentServiceImpl;
    }

    @Override
    public List<NewsCommentsDtoWrapper> find(String text) {
        List<NewsCommentsDtoWrapper> result = new ArrayList<>();
        List<CommentDto> commentDtoList = commentServiceImpl.findAllByWordParts(text);
        List<NewsDto> newsDtoList = newsServiceImpl.findAllByWordParts(text);

        Set<Long> newsIdSetFromComments = commentDtoList.stream()
                .map(commentDto -> commentDto.getNews().getId())
                .collect(Collectors.toSet());
        Set<Long> idSet = newsDtoList.stream()
                .map(NewsDto::getId)
                .collect(Collectors.toSet());
        newsIdSetFromComments.addAll(idSet);

        newsIdSetFromComments.forEach(id -> {
            NewsDto newsDto = newsServiceImpl.findById(id);
            List<CommentDto> comments;
            try {
                comments = commentServiceImpl.findAllByNewsId(id);
            } catch (EntityNotFoundException e) {
                comments = new ArrayList<>();
            }
            result.add(NewsCommentsDtoWrapper.of(newsDto, comments));
        });

        if (result.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return result;
    }

    @Override
    public List<NewsDto> findNewsList(String text) {
        List<NewsDto> newsDtoList = newsServiceImpl.findAllByWordParts(text);
        if(newsDtoList.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return newsDtoList;
    }

    @Override
    public List<CommentDto> findCommentList(String text) {
        List<CommentDto> commentDtoList = commentServiceImpl.findAllByWordParts(text);
        if (commentDtoList.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return commentDtoList;
    }

    @Override
    public PageDto<NewsDto> findNewsPage(String text, Pageable pageable) {
        return newsServiceImpl.findPageByWordParts(text, pageable);
    }

    @Override
    public PageDto<CommentDto> findCommentPage(String text, Pageable pageable) {
        return commentServiceImpl.findPageByWordParts(text, pageable);
    }
}
