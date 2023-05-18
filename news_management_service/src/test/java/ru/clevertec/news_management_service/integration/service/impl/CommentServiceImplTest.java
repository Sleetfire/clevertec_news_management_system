package ru.clevertec.news_management_service.integration.service.impl;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.CreateCommentDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;
import ru.clevertec.news_management_service.integration.BaseIntegrationTest;
import ru.clevertec.news_management_service.service.impl.CommentServiceImpl;
import ru.clevertec.news_management_service.testbuilder.CreateCommentDtoBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommentServiceImplTest extends BaseIntegrationTest {

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @Autowired
    private EntityManager entityManager;

    @Test
    void checkCreateShouldReturnCreatedComment() {
        CreateCommentDto createCommentDto = new CreateCommentDtoBuilder().build();
        long newsId = 1L;

        CommentDto actualCommentDto = commentServiceImpl.create(newsId, createCommentDto);

        assertThat(actualCommentDto.getId())
                .isNotZero();
    }

    @Test
    void checkFindByIdShouldReturnCommentDto() {
        long id = 1L;

        CommentDto actualCommentDto = commentServiceImpl.findById(id);

        assertThat(actualCommentDto.getId())
                .isEqualTo(id);
    }

    @Test
    void checkFindAllShouldReturnNotEmptyCommentDtoList() {
        List<CommentDto> actualCommentDtoList = commentServiceImpl.findAll();

        assertThat(actualCommentDtoList)
                .isNotEmpty();
    }

    @Test
    void checkFindPageByNewsIdShouldReturnCommentDtoPage() {
        long newsId = 1L;
        Pageable pageable = PageRequest.of(0, 1);

        PageDto<CommentDto> actualCommentsPageDto = commentServiceImpl.findPageByNewsId(newsId, pageable);

        assertThat(actualCommentsPageDto.getContent())
                .isNotEmpty();
    }

    @Test
    void checkUpdateShouldReturnUpdatedCommentDto() {
        long id = 1L;
        CreateCommentDto createCommentDto = new CreateCommentDtoBuilder().build();

        CommentDto actualUpdated = commentServiceImpl.update(id, createCommentDto);

        assertThat(actualUpdated.getText())
                .isEqualTo(createCommentDto.getText());
    }

    @Test
    void checkDeleteByIdShouldTrowEntityNotFoundException() {
        long id = 1L;

        commentServiceImpl.deleteById(id);
        entityManager.flush();

        assertThatThrownBy(() -> commentServiceImpl.findById(id))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkFindAllByNewsIdShouldReturnNotEmptyCommentDtoList() {
        long newsId = 1L;

        List<CommentDto> actualCommentDtoList = commentServiceImpl.findAllByNewsId(newsId);

        assertThat(actualCommentDtoList)
                .isNotEmpty();
    }

    @Test
    void checkDeleteAllByNewsIdShouldThrowEntityNotFoundException() {
        long newsId = 1L;

        commentServiceImpl.deleteAllByNewsId(newsId);
        entityManager.flush();

        assertThatThrownBy(() -> commentServiceImpl.findAllByNewsId(newsId))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkFindAllByWordPartsShouldReturnCommentDtoList() {
        String wordPart = "superb";

        List<CommentDto> actualCommentDtoList = commentServiceImpl.findAllByWordParts(wordPart);

        assertThat(actualCommentDtoList)
                .isNotEmpty();
    }

    @Test
    void checkFindPageByWordPartsShouldReturnNotEmptyCommentDtoPage() {
        String wordPart = "superb";
        Pageable pageable = PageRequest.of(0, 1);

        PageDto<CommentDto> actualCommentsPageDto = commentServiceImpl.findPageByWordParts(wordPart, pageable);

        assertThat(actualCommentsPageDto.getContent())
                .isNotEmpty();
    }
}