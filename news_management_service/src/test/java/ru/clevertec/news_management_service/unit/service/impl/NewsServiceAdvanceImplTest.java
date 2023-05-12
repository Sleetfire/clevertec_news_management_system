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
import ru.clevertec.news_management_service.dto.CreateNewsDto;
import ru.clevertec.news_management_service.service.impl.CommentServiceImpl;
import ru.clevertec.news_management_service.service.impl.NewsServiceAdvanceImpl;
import ru.clevertec.news_management_service.service.impl.NewsServiceImpl;
import ru.clevertec.news_management_service.testbuilder.CreateNewsDtoBuilder;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class NewsServiceAdvanceImplTest {

    @MockBean
    private CommentServiceImpl commentServiceImpl;

    @MockBean
    private NewsServiceImpl newsServiceImpl;

    @Autowired
    @InjectMocks
    private NewsServiceAdvanceImpl newsServiceAdvance;

    @Test
    void checkCreateShouldCallTestedMethod() {
        CreateNewsDto createNewsDto = new CreateNewsDtoBuilder().build();

        newsServiceAdvance.create(createNewsDto);

        verify(newsServiceImpl)
                .create(createNewsDto);
    }

    @Test
    void checkFindByIdShouldCallTestedMethod() {
        long id = 1L;

        newsServiceAdvance.findById(id);

        verify(newsServiceImpl)
                .findById(id);
    }

    @Test
    void checkFindAllShouldCallTestedMethod() {
        newsServiceAdvance.findAll();

        verify(newsServiceImpl)
                .findAll();
    }

    @Test
    void checkFindPageShouldCallTestedMethod() {
        Pageable pageable = PageRequest.of(0, 1);
        newsServiceAdvance.findPage(pageable);

        verify(newsServiceImpl)
                .findPage(pageable);
    }

    @Test
    void checkUpdateShouldCallTestedMethod() {
        long id = 1L;
        CreateNewsDto createNewsDto = new CreateNewsDtoBuilder().build();

        newsServiceAdvance.update(id, createNewsDto);

        verify(newsServiceImpl)
                .update(id, createNewsDto);
    }

    @Test
    void checkDeleteByIdShouldCallTestedMethod() {
        long id = 1L;

        newsServiceAdvance.deleteById(id);

        verify(commentServiceImpl)
                .deleteAllByNewsId(id);

        verify(newsServiceImpl)
                .deleteById(id);
    }

    @Test
    void checkFindAllByWordPartsShouldCallTestedMethod() {
        String wordPart = "default";

        newsServiceAdvance.findAllByWordParts(wordPart);

        verify(newsServiceImpl)
                .findAllByWordParts(wordPart);
    }

    @Test
    void checkFindPageByWordPartsShouldCallTestedMethod() {
        Pageable pageable = PageRequest.of(0, 1);
        String wordPart = "default";

        newsServiceAdvance.findPageByWordParts(wordPart, pageable);

        verify(newsServiceImpl)
                .findPageByWordParts(wordPart, pageable);
    }

    @Test
    void checkFindNewsCommentsPageById() {
        Pageable pageable = PageRequest.of(0, 1);
        long id = 1L;

        newsServiceAdvance.findNewsCommentsPageById(id, pageable);

        verify(newsServiceImpl)
                .findById(id);

        verify(commentServiceImpl)
                .findPageByNewsId(id, pageable);
    }
}