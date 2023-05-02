package ru.clevertec.news_management_service.service;

import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.CreateNewsDto;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;

import java.util.List;

public interface NewsService {

    NewsDto create(CreateNewsDto news);

    NewsDto findById(long id);

    List<NewsDto> findAll();

    PageDto<NewsDto> findPage(Pageable pageable);

    NewsDto update(long id, CreateNewsDto updatedNews);

    void deleteById(long id);

    List<NewsDto> findAllByWordParts(String wordParts);

    PageDto<NewsDto> findPageByWordParts(String wordParts, Pageable pageable);

}
