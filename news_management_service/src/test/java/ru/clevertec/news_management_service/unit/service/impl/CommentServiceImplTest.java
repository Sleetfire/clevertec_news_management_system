package ru.clevertec.news_management_service.unit.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.CreateCommentDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;
import ru.clevertec.news_management_service.mapper.CommentMapper;
import ru.clevertec.news_management_service.repository.CommentRepository;
import ru.clevertec.news_management_service.repository.entity.Comment;
import ru.clevertec.news_management_service.service.impl.CommentServiceImpl;
import ru.clevertec.news_management_service.service.impl.NewsServiceImpl;
import ru.clevertec.news_management_service.testbuilder.CreateCommentDtoBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static ru.clevertec.news_management_service.testbuilder.CommentDtoFixture.*;
import static ru.clevertec.news_management_service.testbuilder.NewsDtoFixture.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    @MockBean
    private CommentRepository commentRepository;

    @MockBean
    private NewsServiceImpl newsServiceImpl;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    @InjectMocks
    private CommentServiceImpl commentServiceImpl;

    @Test
    void checkCreateShouldCallTestedMethod() {
        CreateCommentDto createCommentDto = new CreateCommentDtoBuilder().build();
        CommentDto expectedCommentDto = COMMENT_DTO;
        Comment comment = commentMapper.toEntity(expectedCommentDto);
        long newsId = 1L;

        doReturn(NEWS_DTO)
                .when(newsServiceImpl)
                .findById(newsId);
        doReturn(comment)
                .when(commentRepository)
                .save(any(Comment.class));

        CommentDto actualCommentDto = commentServiceImpl.create(newsId, createCommentDto);

        assertThat(actualCommentDto)
                .isEqualTo(expectedCommentDto);
    }

    @Test
    void checkFindByIdShouldReturnCommentDto() {
        CommentDto expectedCommentDto = COMMENT_DTO;
        Comment comment = commentMapper.toEntity(expectedCommentDto);
        Optional<Comment> commentOptional = Optional.of(comment);
        long id = 1L;

        doReturn(commentOptional)
                .when(commentRepository)
                .findById(id);

        CommentDto actualCommentDto = commentServiceImpl.findById(id);

        assertThat(actualCommentDto)
                .isEqualTo(expectedCommentDto);
    }

    @Test
    void checkFindByIdShouldThrowEntityNotFoundException() {
        Optional<Comment> optionalComment = Optional.empty();
        long id = 1L;

        doReturn(optionalComment)
                .when(commentRepository)
                .findById(id);

        assertThatThrownBy(() -> commentServiceImpl.findById(id))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkFindAllShouldReturnListOfCommentDto() {
        List<CommentDto> expectedCommentDtoList = getCommentDtoList(3);
        List<Comment> commentList = commentMapper.toEntity(expectedCommentDtoList);

        doReturn(commentList)
                .when(commentRepository)
                .findAll();

        List<CommentDto> actualCommentDtoList = commentServiceImpl.findAll();

        assertThat(actualCommentDtoList)
                .hasSameElementsAs(expectedCommentDtoList);
    }

    @Test
    void checkFindAllShouldThrowEntityNotFoundException() {
        doReturn(Collections.emptyList())
                .when(commentRepository)
                .findAll();

        assertThatThrownBy(() -> commentServiceImpl.findAll())
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void findPageByNewsId() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void checkFindAllByNewsIdShouldReturnListOfCommentDto() {
        List<CommentDto> expectedCommentDtoList = getCommentDtoList(3);
        List<Comment> commentList = commentMapper.toEntity(expectedCommentDtoList);
        long newsId = 1L;

        doReturn(commentList)
                .when(commentRepository)
                .findAllByNewsId(newsId);

        List<CommentDto> actualCommentDtoList = commentServiceImpl.findAllByNewsId(newsId);

        assertThat(actualCommentDtoList)
                .hasSameElementsAs(expectedCommentDtoList);
    }

    @Test
    void checkFindAllByNewsIdShouldThrowEntityNotFoundException() {
        long newsId = 1L;

        doReturn(Collections.emptyList())
                .when(commentRepository)
                .findAllByNewsId(newsId);

        assertThatThrownBy(() -> commentServiceImpl.findAllByNewsId(newsId))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void deleteAllByNewsId() {
    }

    @Test
    void findAllByWordParts() {
    }

    @Test
    void findPageByWordParts() {
    }
}