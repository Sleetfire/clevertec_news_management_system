package ru.clevertec.news_management_service.unit.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.NewsCommentsDtoWrapper;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;
import ru.clevertec.news_management_service.service.impl.CommentServiceImpl;
import ru.clevertec.news_management_service.service.impl.FullTextSearchServiceImpl;
import ru.clevertec.news_management_service.service.impl.NewsServiceImpl;
import ru.clevertec.news_management_service.testbuilder.CommentDtoFixture;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static ru.clevertec.news_management_service.testbuilder.NewsDtoFixture.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FullTextSearchServiceImplTest {

    @MockBean
    private CommentServiceImpl commentServiceImpl;

    @MockBean
    private NewsServiceImpl newsServiceImpl;

    @Autowired
    @InjectMocks
    private FullTextSearchServiceImpl fullTextSearchService;

    @Test
    void checkFindShouldReturnNewsCommentsDtoWrapper() {
        List<NewsDto> newsDtoList = getNewsDtoList(1);
        List<CommentDto> commentDtoList = CommentDtoFixture.getCommentDtoList(3);
        String wordPart = "default";

        doReturn(newsDtoList)
                .when(newsServiceImpl)
                .findAllByWordParts(wordPart);

        doReturn(NEWS_DTO)
                .when(newsServiceImpl)
                .findById(anyLong());

        doReturn(commentDtoList)
                .when(commentServiceImpl)
                .findAllByWordParts(wordPart);

        doReturn(commentDtoList)
                .when(commentServiceImpl)
                .findAllByNewsId(anyLong());

        List<NewsCommentsDtoWrapper> actualNewsCommentsDtoWrappers = fullTextSearchService.find(wordPart);
        assertThat(actualNewsCommentsDtoWrappers.get(0))
                .extracting(NewsCommentsDtoWrapper::getNews, NewsCommentsDtoWrapper::getComments)
                .containsExactly(NEWS_DTO, commentDtoList);
    }

    @Test
    void checkFindNewsListShouldThrowEntityNotFoundException() {
        String wordPart = "default";

        doReturn(Collections.emptyList())
                .when(newsServiceImpl)
                .findAllByWordParts(wordPart);

        assertThatThrownBy(() -> fullTextSearchService.findNewsList(wordPart))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkFindCommentListShouldThrowEntityNotFoundException() {
        String wordPart = "default";

        doReturn(Collections.emptyList())
                .when(commentServiceImpl)
                .findAllByWordParts(wordPart);

        assertThatThrownBy(() -> fullTextSearchService.findCommentList(wordPart))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkFindNewsPageShouldCallTestedMethod() {
        Pageable pageable = PageRequest.of(0, 1);
        String wordPart = "default";

        fullTextSearchService.findNewsPage(wordPart, pageable);

        verify(newsServiceImpl)
                .findPageByWordParts(wordPart, pageable);
    }

    @Test
    void checkFindCommentPageShouldCallTestedMethod() {
        Pageable pageable = PageRequest.of(0, 1);
        String wordPart = "default";

        fullTextSearchService.findCommentPage(wordPart, pageable);

        verify(commentServiceImpl)
                .findPageByWordParts(wordPart, pageable);
    }
}