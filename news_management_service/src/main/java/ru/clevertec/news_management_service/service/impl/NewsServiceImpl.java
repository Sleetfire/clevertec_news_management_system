package ru.clevertec.news_management_service.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.news_management_service.aop.annotation.Loggable;
import ru.clevertec.news_management_service.dto.CreateNewsDto;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;
import ru.clevertec.news_management_service.mapper.NewsMapper;
import ru.clevertec.news_management_service.repository.NewsRepository;
import ru.clevertec.news_management_service.repository.entity.News;
import ru.clevertec.news_management_service.service.NewsService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public NewsServiceImpl(NewsRepository newsRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    @Override
    @Loggable
    @Transactional
    public NewsDto create(CreateNewsDto news) {
        NewsDto newsDto = NewsDto.builder()
                .title(news.getTitle())
                .text(news.getText())
                .time(LocalDateTime.now())
                .build();
        News createdNews = newsRepository.save(newsMapper.toEntity(newsDto));
        return newsMapper.toDto(createdNews);
    }

    @Override
    public NewsDto findById(long id) {
        Optional<News> optionalNews = newsRepository.findById(id);
        if (optionalNews.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return newsMapper.toDto(optionalNews.get());
    }

    @Override
    public List<NewsDto> findAll() {
        List<News> newsList = newsRepository.findAll();
        if (newsList.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return newsMapper.toDto(newsList);
    }

    @Override
    public PageDto<NewsDto> findPage(Pageable pageable) {
        Page<News> page = newsRepository.findAll(pageable);
        return convertPage(page);
    }

    @Override
    @Loggable
    @Transactional
    public NewsDto update(long id, CreateNewsDto updatedNews) {
        Optional<News> newsOptional = newsRepository.findById(id);
        if (newsOptional.isEmpty()) {
            throw new EntityNotFoundException();
        }

        News newsFromDb = newsOptional.get();
        String updatedTitle = updatedNews.getTitle();
        String updatedText = updatedNews.getText();

        if (!Objects.equals(updatedTitle, newsFromDb.getTitle())) {
            newsFromDb.setTitle(updatedTitle);
        }

        if (!Objects.equals(updatedText, newsFromDb.getText())) {
            newsFromDb.setText(updatedText);
        }

        News updated = newsRepository.save(newsFromDb);

        return newsMapper.toDto(updated);
    }

    @Override
    @Loggable
    @Transactional
    public void deleteById(long id) {
        Optional<News> optionalNews = newsRepository.findById(id);
        if (optionalNews.isEmpty()) {
            throw new EntityNotFoundException();
        }

        newsRepository.deleteById(id);
    }

    @Override
    public List<NewsDto> findAllByWordParts(String wordParts) {
        String findWord = "%" + wordParts + "%";
        List<News> newsList = newsRepository.findAllByWordParts(findWord);
        return newsMapper.toDto(newsList);
    }

    @Override
    public PageDto<NewsDto> findPageByWordParts(String wordParts, Pageable pageable) {
        String findWord = "%" + wordParts + "%";
        Page<News> page = newsRepository.findAllByWordParts(findWord, pageable);
        return convertPage(page);
    }

    private PageDto<NewsDto> convertPage(Page<News> page) {
        if (page.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return PageDto.Builder.createBuilder(NewsDto.class)
                .setNumber(page.getNumber())
                .setSize(page.getSize())
                .setTotalPages(page.getTotalPages())
                .setTotalElements(page.getTotalElements())
                .setFirst(page.isFirst())
                .setNumberOfElements(page.getNumberOfElements())
                .setLast(page.isLast())
                .setContent(newsMapper.toDto(page.getContent()))
                .build();
    }
}
