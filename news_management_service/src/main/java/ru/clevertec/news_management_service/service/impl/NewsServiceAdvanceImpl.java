package ru.clevertec.news_management_service.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.clevertec.news_management_service.dto.*;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;
import ru.clevertec.news_management_service.service.CommentService;
import ru.clevertec.news_management_service.service.NewsService;
import ru.clevertec.news_management_service.service.NewsServiceAdvance;

import java.util.List;

@Service
public class NewsServiceAdvanceImpl implements NewsServiceAdvance {

    private final NewsService newsServiceImpl;
    private final CommentService commentServiceImpl;

    public NewsServiceAdvanceImpl(NewsService newsServiceImpl, CommentService commentServiceImpl) {
        this.newsServiceImpl = newsServiceImpl;
        this.commentServiceImpl = commentServiceImpl;
    }

    @Override
    public NewsDto create(CreateNewsDto news) {
        return newsServiceImpl.create(news);
    }

    @Override
    public NewsDto findById(long id) {
        return newsServiceImpl.findById(id);
    }

    @Override
    public List<NewsDto> findAll() {
        return newsServiceImpl.findAll();
    }

    @Override
    public PageDto<NewsDto> findPage(Pageable pageable) {
        return newsServiceImpl.findPage(pageable);
    }

    @Override
    public NewsDto update(long id, CreateNewsDto updatedNews) {
        return newsServiceImpl.update(id, updatedNews);
    }

    @Override
    public void deleteById(long id) {
        commentServiceImpl.deleteAllByNewsId(id);
        newsServiceImpl.deleteById(id);
    }

    @Override
    public List<NewsDto> findAllByWordParts(String wordParts) {
        return newsServiceImpl.findAllByWordParts(wordParts);
    }

    @Override
    public PageDto<NewsDto> findPageByWordParts(String wordParts, Pageable pageable) {
        return newsServiceImpl.findPageByWordParts(wordParts, pageable);
    }

    @Override
    public NewsCommentsPageWrapperDto findNewsCommentsPageById(long id, Pageable pageable) {
        NewsDto news = newsServiceImpl.findById(id);
        PageDto<CommentDto> commentsPage;
        try {
            commentsPage = commentServiceImpl.findPageByNewsId(id, pageable);
        } catch (EntityNotFoundException e) {
            commentsPage = new PageDto<>();
        }
        return NewsCommentsPageWrapperDto.of(news, commentsPage);
    }
}
