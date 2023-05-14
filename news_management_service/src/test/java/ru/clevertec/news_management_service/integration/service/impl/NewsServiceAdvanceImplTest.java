package ru.clevertec.news_management_service.integration.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.CreateNewsDto;
import ru.clevertec.news_management_service.dto.NewsCommentsPageWrapperDto;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;
import ru.clevertec.news_management_service.integration.BaseIntegrationTest;
import ru.clevertec.news_management_service.service.impl.NewsServiceAdvanceImpl;
import ru.clevertec.news_management_service.testbuilder.CreateNewsDtoBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NewsServiceAdvanceImplTest extends BaseIntegrationTest {

    @Autowired
    private NewsServiceAdvanceImpl newsServiceAdvanceImpl;

    @Test
    void checkCreateShouldReturnCreatedNewsDto() {
        CreateNewsDto createNewsDto = new CreateNewsDtoBuilder().build();

        NewsDto actualNewsDto = newsServiceAdvanceImpl.create(createNewsDto);

        assertThat(actualNewsDto.getId())
                .isNotZero();
    }

    @Test
    void checkFindByIdShouldReturnNewsDtoWithId1() {
        long id = 1L;

        NewsDto actualNewsDto = newsServiceAdvanceImpl.findById(id);

        assertThat(actualNewsDto.getId()).isEqualTo(id);
    }

    @Test
    void checkFindAllShouldReturnNotEmptyList() {
        List<NewsDto> actualNewsDtoList = newsServiceAdvanceImpl.findAll();

        assertThat(actualNewsDtoList).isNotEmpty();
    }

    @Test
    void checkFindPageShouldReturnPageDtoWithNotEmptyContent() {
        Pageable pageable = PageRequest.of(0, 1);

        PageDto<NewsDto> actualPageDto = newsServiceAdvanceImpl.findPage(pageable);

        assertThat(actualPageDto.getContent())
                .isNotEmpty();
    }

    @Test
    void checkUpdateShouldReturnUpdatedNewsDto() {
        CreateNewsDto createNewsDto = new CreateNewsDtoBuilder().build();
        long id = 1L;

        NewsDto updatedNewsDto = newsServiceAdvanceImpl.update(id, createNewsDto);
        assertThat(updatedNewsDto)
                .extracting(NewsDto::getTitle, NewsDto::getText)
                .containsExactly(createNewsDto.getTitle(), createNewsDto.getText());
    }

    @Test
    void checkDeleteByIdShouldThrowEntityNotFoundException() {
        long id = 2L;

        newsServiceAdvanceImpl.deleteById(id);

        assertThatThrownBy(() -> newsServiceAdvanceImpl.findById(id))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkFindAllByWordPartsShouldReturnNotEmptyList() {
        String wordPart = "Lionel";

        List<NewsDto> actualNewsDtoList = newsServiceAdvanceImpl.findAllByWordParts(wordPart);

        assertThat(actualNewsDtoList)
                .isNotEmpty();
    }

    @Test
    void checkFindPageByWordPartsShouldReturnNotEmptyPageDto() {
        Pageable pageable = PageRequest.of(0, 1);
        String wordPart = "Lionel";

        PageDto<NewsDto> actualPageDto = newsServiceAdvanceImpl.findPageByWordParts(wordPart, pageable);

        assertThat(actualPageDto.getContent())
                .isNotEmpty();
    }

    @Test
    void checkFindNewsCommentsPageByIdShouldReturnNewsDtoAndCommentsWrapper() {
        long newsId = 1L;
        Pageable pageable = PageRequest.of(0, 1);

        NewsCommentsPageWrapperDto actual = newsServiceAdvanceImpl.findNewsCommentsPageById(newsId, pageable);

        assertThat(actual.getNews().getId())
                .isEqualTo(newsId);
    }
}