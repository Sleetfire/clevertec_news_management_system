package ru.clevertec.news_management_service.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.CreateCommentDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.mapper.CommentMapper;
import ru.clevertec.news_management_service.repository.CommentRepository;
import ru.clevertec.news_management_service.repository.entity.Comment;
import ru.clevertec.news_management_service.service.CommentService;
import ru.clevertec.news_management_service.service.NewsService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final NewsService newsService;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper, NewsService newsService) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.newsService = newsService;
    }

    @Override
    @Transactional
    public CommentDto create(CreateCommentDto comment) {
        CommentDto commentDto = CommentDto.builder()
                .time(LocalDateTime.now())
                .text(comment.getText())
                .username(comment.getUsername())
                .news(newsService.findById(comment.getNewsId()))
                .build();
        Comment createdComment = commentRepository.save(commentMapper.toEntity(commentDto));
        return commentMapper.toDto(createdComment);
    }

    @Override
    public CommentDto findById(long id) {
        return null;
    }

    @Override
    public List<CommentDto> findAll() {
        return null;
    }

    @Override
    public PageDto<CommentDto> findPageByNewsId(long newsId, Pageable pageable) {
        return null;
    }

    @Override
    @Transactional
    public CommentDto update(long id, CreateCommentDto updatedComment) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(long id) {

    }
}
