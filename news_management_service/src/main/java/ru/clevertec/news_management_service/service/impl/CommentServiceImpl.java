package ru.clevertec.news_management_service.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.news_management_service.aop.annotation.Loggable;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.CreateCommentDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;
import ru.clevertec.news_management_service.mapper.CommentMapper;
import ru.clevertec.news_management_service.repository.CommentRepository;
import ru.clevertec.news_management_service.repository.entity.Comment;
import ru.clevertec.news_management_service.service.CommentService;
import ru.clevertec.news_management_service.service.NewsService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.clevertec.news_management_service.service.util.Constants.COMMENT_LIST_NOT_FOUND_MESSAGE;
import static ru.clevertec.news_management_service.service.util.Constants.COMMENT_NOT_FOUND_MESSAGE;
import static ru.clevertec.news_management_service.service.util.Constants.COMMENT_PAGE_NOT_FOUND_MESSAGE;

@Service
@Transactional(readOnly = true, noRollbackForClassName = {"ru.clevertec.news_management_service.exception.EntityNotFoundException"})
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final NewsService newsServiceImpl;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper, NewsService newsServiceImpl) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.newsServiceImpl = newsServiceImpl;
    }

    @Override
    @Loggable
    @CachePut(value = "comments", key = "#result.id")
    @Transactional
    public CommentDto create(long newsId, CreateCommentDto comment) {
        CommentDto commentDto = CommentDto.builder()
                .time(LocalDateTime.now())
                .text(comment.getText())
                .username(comment.getUsername())
                .news(newsServiceImpl.findById(newsId))
                .build();
        Comment createdComment = commentRepository.save(commentMapper.toEntity(commentDto));
        return commentMapper.toDto(createdComment);
    }

    @Override
    @Cacheable(value = "comments", key = "#id")
    public CommentDto findById(long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        Comment comment = optionalComment.orElseThrow(() -> new EntityNotFoundException(COMMENT_NOT_FOUND_MESSAGE));
        return commentMapper.toDto(comment);
    }

    @Override
    public List<CommentDto> findAll() {
        List<Comment> commentList = commentRepository.findAll();
        if (commentList.isEmpty()) {
            throw new EntityNotFoundException(COMMENT_LIST_NOT_FOUND_MESSAGE);
        }
        return commentMapper.toDto(commentList);
    }

    @Override
    public PageDto<CommentDto> findPageByNewsId(long newsId, Pageable pageable) {
        Page<Comment> page = commentRepository.findAllByNewsId(newsId, pageable);
        return convertPage(page);
    }

    @Override
    @Loggable
    @CachePut(value = "comments", key = "#result.id")
    @Transactional
    public CommentDto update(long id, CreateCommentDto updatedComment) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new EntityNotFoundException(COMMENT_NOT_FOUND_MESSAGE);
        }

        Comment commentFromDb = optionalComment.get();
        String updatedText = updatedComment.getText();

        if (!Objects.equals(updatedText, commentFromDb.getText())) {
            commentFromDb.setText(updatedText);
        }

        Comment updated = commentRepository.save(commentFromDb);
        return commentMapper.toDto(updated);
    }

    @Override
    @Loggable
    @CacheEvict(value = "comments", key = "#id")
    @Transactional
    public void deleteById(long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new EntityNotFoundException(COMMENT_NOT_FOUND_MESSAGE);
        }
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentDto> findAllByNewsId(long id) {
        List<Comment> commentList = commentRepository.findAllByNewsId(id);
        if (commentList.isEmpty()) {
            throw new EntityNotFoundException(COMMENT_LIST_NOT_FOUND_MESSAGE);
        }
        return commentMapper.toDto(commentList);
    }

    @Override
    @Loggable
    @Transactional
    public void deleteAllByNewsId(long newsId) {
        commentRepository.deleteAllByNewsId(newsId);
    }

    @Override
    public List<CommentDto> findAllByWordParts(String wordParts) {
        String findQuery = "%" + wordParts + "%";
        List<Comment> commentList = commentRepository.findAllByWordParts(findQuery);
        return commentMapper.toDto(commentList);
    }

    @Override
    public PageDto<CommentDto> findPageByWordParts(String wordParts, Pageable pageable) {
        String findQuery = "%" + wordParts + "%";
        Page<Comment> page = commentRepository.findAllByWordParts(findQuery, pageable);
        return convertPage(page);
    }

    private PageDto<CommentDto> convertPage(Page<Comment> page) {
        if (page.isEmpty()) {
            throw new EntityNotFoundException(COMMENT_PAGE_NOT_FOUND_MESSAGE);
        }
        return PageDto.Builder.createBuilder(CommentDto.class)
                .setNumber(page.getNumber())
                .setSize(page.getSize())
                .setTotalPages(page.getTotalPages())
                .setTotalElements(page.getTotalElements())
                .setFirst(page.isFirst())
                .setNumberOfElements(page.getNumberOfElements())
                .setLast(page.isLast())
                .setContent(commentMapper.toDto(page.getContent()))
                .build();
    }
}
