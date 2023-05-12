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
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.CreateCommentDto;
import ru.clevertec.news_management_service.dto.PageDto;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static ru.clevertec.news_management_service.testbuilder.CommentDtoFixture.COMMENT_DTO;
import static ru.clevertec.news_management_service.testbuilder.CommentDtoFixture.getCommentDtoList;
import static ru.clevertec.news_management_service.testbuilder.NewsDtoFixture.NEWS_DTO;

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
    void checkCreateShouldReturnCommentDto() {
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
    void checkFindPageByNewsIdShouldReturnCommentPageDto() {
        List<CommentDto> commentDtoList = getCommentDtoList(3);
        List<Comment> content = commentMapper.toEntity(commentDtoList);
        Pageable pageable = PageRequest.of(0, 1);
        Page<Comment> page = new PageImpl<>(content, pageable, content.size());
        long newsId = 1L;

        doReturn(page)
                .when(commentRepository)
                .findAllByNewsId(newsId, pageable);

        PageDto<CommentDto> actualPageDto = commentServiceImpl.findPageByNewsId(newsId, pageable);

        assertThat(actualPageDto)
                .extracting(PageDto::getNumber, PageDto::getSize, PageDto::getTotalPages, PageDto::getNumberOfElements,
                        PageDto::isFirst, PageDto::getNumberOfElements, PageDto::isLast, PageDto::getContent)
                .containsExactly(0, 1, 3, 3, true, 3, false, commentDtoList);
    }

    @Test
    void checkFindPageByNewsIdShouldThrowEntityNotFoundException() {
        Page<Comment> page = Page.empty();
        Pageable pageable = PageRequest.of(0, 1);
        long newsId = 1L;

        doReturn(page)
                .when(commentRepository)
                .findAllByNewsId(newsId, pageable);

        assertThatThrownBy(() -> commentServiceImpl.findPageByNewsId(newsId, pageable))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkUpdateShouldCallTestedMethod() {
        CreateCommentDto updated = new CreateCommentDtoBuilder()
                .withText("updated-text")
                .withUsername("updated-username")
                .build();
        Comment comment = commentMapper.toEntity(COMMENT_DTO);
        Optional<Comment> optionalComment = Optional.of(comment);
        long id = 1L;

        doReturn(optionalComment)
                .when(commentRepository)
                .findById(id);

        commentServiceImpl.update(id, updated);

        verify(commentRepository)
                .save(any(Comment.class));
    }

    @Test
    void checkUpdateShouldThrowEntityNotFoundException() {
        Optional<Comment> commentOptional = Optional.empty();
        CreateCommentDto updated = new CreateCommentDtoBuilder()
                .withText("updated-text")
                .withUsername("updated-username")
                .build();
        long id = 1L;

        doReturn(commentOptional)
                .when(commentRepository)
                .findById(id);

        assertThatThrownBy(() -> commentServiceImpl.update(id, updated))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void checkDeleteByIdShouldCallTestedMethod() {
        Comment comment = commentMapper.toEntity(COMMENT_DTO);
        Optional<Comment> optionalComment = Optional.of(comment);
        long id = 1L;

        doReturn(optionalComment)
                .when(commentRepository)
                .findById(id);

        commentServiceImpl.deleteById(id);

        verify(commentRepository)
                .deleteById(id);
    }

    @Test
    void checkDeleteByIdShouldThrowEntityNotFoundException() {
        Optional<Comment> commentOptional = Optional.empty();
        long id = 1L;

        doReturn(commentOptional)
                .when(commentRepository)
                .findById(id);

        assertThatThrownBy(() -> commentServiceImpl.deleteById(id))
                .isInstanceOf(EntityNotFoundException.class);
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
    void checkDeleteAllByNewsIdShouldCallTestedMethod() {
        long newsId = 1L;

        commentServiceImpl.deleteAllByNewsId(newsId);

        verify(commentRepository)
                .deleteAllByNewsId(newsId);
    }

    @Test
    void checkFindAllByWordPartsShouldReturnListOfCommentDto() {
        List<CommentDto> expectedCommentDtoList = getCommentDtoList(3);
        List<Comment> commentList = commentMapper.toEntity(expectedCommentDtoList);
        String wordPart = "default";
        String searchWordPart = "%" + wordPart + "%";

        doReturn(commentList)
                .when(commentRepository)
                .findAllByWordParts(searchWordPart);

        List<CommentDto> actualCommentDtoList = commentServiceImpl.findAllByWordParts(wordPart);

        assertThat(actualCommentDtoList)
                .hasSameElementsAs(expectedCommentDtoList);
    }

    @Test
    void checkFindAllByWordPartsShouldThrowEntityNotFoundException() {
        String wordPart = "default";
        String searchWordPart = "%" + wordPart + "%";

        doReturn(Collections.emptyList())
                .when(commentRepository)
                .findAllByWordParts(searchWordPart);

        List<CommentDto> actualCommentDtoList = commentServiceImpl.findAllByWordParts(wordPart);

        assertThat(actualCommentDtoList)
                .isEmpty();
    }

    @Test
    void checkFindPageByWordPartsShouldReturnPageDto() {
        List<CommentDto> commentDtoList = getCommentDtoList(3);
        List<Comment> content = commentMapper.toEntity(commentDtoList);
        Pageable pageable = PageRequest.of(0, 1);
        Page<Comment> page = new PageImpl<>(content, pageable, content.size());
        String wordPart = "default";
        String searchWordPart = "%" + wordPart + "%";

        doReturn(page)
                .when(commentRepository)
                .findAllByWordParts(searchWordPart, pageable);

        PageDto<CommentDto> actualPageDto = commentServiceImpl.findPageByWordParts(wordPart, pageable);

        assertThat(actualPageDto)
                .extracting(PageDto::getNumber, PageDto::getSize, PageDto::getTotalPages, PageDto::getNumberOfElements,
                        PageDto::isFirst, PageDto::getNumberOfElements, PageDto::isLast, PageDto::getContent)
                .containsExactly(0, 1, 3, 3, true, 3, false, commentDtoList);
    }

}