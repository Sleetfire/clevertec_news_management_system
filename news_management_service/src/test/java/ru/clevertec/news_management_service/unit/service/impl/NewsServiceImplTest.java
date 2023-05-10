package ru.clevertec.news_management_service.unit.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.CreateNewsDto;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;
import ru.clevertec.news_management_service.mapper.NewsMapper;
import ru.clevertec.news_management_service.repository.NewsRepository;
import ru.clevertec.news_management_service.repository.entity.News;
import ru.clevertec.news_management_service.service.impl.NewsServiceImpl;
import ru.clevertec.news_management_service.testbuilder.CreateNewsDtoBuilder;
import ru.clevertec.news_management_service.testbuilder.NewsDtoBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static ru.clevertec.news_management_service.testbuilder.NewsDtoFixture.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class NewsServiceImplTest {

    @MockBean
    private NewsRepository newsRepository;

    @Autowired
    @InjectMocks
    private NewsServiceImpl newsServiceImpl;

    @Autowired
    private NewsMapper newsMapper;

    @Test
    void checkCreateShouldCallTestMethod() {
        CreateNewsDto createNewsDto = new CreateNewsDtoBuilder().build();

        newsServiceImpl.create(createNewsDto);

        verify(newsRepository)
                .save(any(News.class));
    }

    @Test
    void checkFindByIdShouldReturnNewsDto() {
        NewsDto expectedNews = NEWS_DTO;
        News news = newsMapper.toEntity(expectedNews);
        Optional<News> optionalNews = Optional.of(news);
        long id = 1L;

        doReturn(optionalNews)
                .when(newsRepository)
                .findById(id);

        NewsDto actualNews = newsServiceImpl.findById(id);

        assertThat(actualNews)
                .isEqualTo(expectedNews);
    }

    @Test
    void checkFindByIdShouldThrowEntityNotFoundException() {
        Optional<News> optionalNews = Optional.empty();
        long id = 1L;

        doReturn(optionalNews)
                .when(newsRepository)
                .findById(id);

        assertThatThrownBy(() -> newsServiceImpl.findById(id))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkFindAllShouldReturnListOfNewsDto() {
        List<NewsDto> expectedNewsDtoList = getNewsDtoList(3);
        List<News> news = newsMapper.toEntity(expectedNewsDtoList);

        doReturn(news)
                .when(newsRepository)
                .findAll();

        List<NewsDto> actualNewsDtoList = newsServiceImpl.findAll();

        assertThat(actualNewsDtoList)
                .hasSameElementsAs(expectedNewsDtoList);
    }

    @Test
    void checkFindAllShouldThrowEssenceNotFoundException() {
        doReturn(Collections.emptyList())
                .when(newsRepository)
                .findAll();

        assertThatThrownBy(() -> newsServiceImpl.findAll())
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkFindPageShouldReturnPageDto() {
        List<NewsDto> newsDtoList = getNewsDtoList(3);
        List<News> content = newsMapper.toEntity(newsDtoList);
        Pageable pageable = PageRequest.of(0, 1);
        Page<News> page = new PageImpl<>(content, pageable, content.size());

        doReturn(page)
                .when(newsRepository)
                .findAll(pageable);

        PageDto<NewsDto> actualPageDto = newsServiceImpl.findPage(pageable);

        assertThat(actualPageDto.getNumber()).isZero();
        assertThat(actualPageDto.getSize()).isEqualTo(1);
        assertThat(actualPageDto.getTotalPages()).isEqualTo(3);
        assertThat(actualPageDto.getTotalElements()).isEqualTo(3L);
        assertThat(actualPageDto.isFirst()).isTrue();
        assertThat(actualPageDto.getNumberOfElements()).isEqualTo(3);
        assertThat(actualPageDto.isLast()).isFalse();
        assertThat(actualPageDto.getContent()).hasSameElementsAs(newsDtoList);
    }

    @Test
    void checkFindPageShouldThrowEntityNotFoundException() {
        Page<News> page = Page.empty();
        Pageable pageable = PageRequest.of(0, 1);

        doReturn(page)
                .when(newsRepository)
                .findAll(pageable);

        assertThatThrownBy(() -> newsServiceImpl.findPage(pageable))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkUpdateShouldReturnCallTestedMethod() {
        NewsDto expectedNewsDto = new NewsDtoBuilder()
                .withTitle("updated-title")
                .withText("updated-text")
                .build();
        CreateNewsDto updated = new CreateNewsDtoBuilder()
                .withTitle("updated-title")
                .withText("updated-text")
                .build();
        News news = newsMapper.toEntity(NEWS_DTO);
        News updatedNews = newsMapper.toEntity(expectedNewsDto);
        Optional<News> optionalNews = Optional.of(news);
        long id = 1L;

        doReturn(optionalNews)
                .when(newsRepository)
                .findById(id);

        newsServiceImpl.update(id, updated);

        verify(newsRepository)
                .save(any(News.class));
    }

    @Test
    void checkUpdateShouldThrowEssenceNotFoundException() {
        Optional<News> optionalNews = Optional.empty();
        CreateNewsDto createNewsDto = new CreateNewsDtoBuilder().build();
        long id = 1L;

        doReturn(optionalNews)
                .when(newsRepository)
                .findById(id);

        assertThatThrownBy(() -> newsServiceImpl.update(id, createNewsDto))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkDeleteByIdShouldCallTestedMethod() {
        News news = newsMapper.toEntity(NEWS_DTO);
        Optional<News> optionalNews = Optional.of(news);
        long id = 1L;

        doReturn(optionalNews)
                .when(newsRepository)
                .findById(id);
        doNothing()
                .when(newsRepository)
                .deleteById(id);

        newsServiceImpl.deleteById(id);

        verify(newsRepository)
                .deleteById(id);
    }

    @Test
    void checkDeleteByIdShouldThrowEssenceNotFoundException() {
        Optional<News> optionalNews = Optional.empty();
        long id = 1L;

        doReturn(optionalNews)
                .when(newsRepository)
                .findById(id);

        assertThatThrownBy(() -> newsServiceImpl.deleteById(id))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void findAllByWordParts() {
    }

    @Test
    void findPageByWordParts() {
    }
}