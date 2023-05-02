package ru.clevertec.news_management_service.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public CommentDto create(long newsId, CreateCommentDto comment) {
        CommentDto commentDto = CommentDto.builder()
                .time(LocalDateTime.now())
                .text(comment.getText())
                .username(comment.getUsername())
                .news(newsService.findById(newsId))
                .build();
        Comment createdComment = commentRepository.save(commentMapper.toEntity(commentDto));
        return commentMapper.toDto(createdComment);
    }

    @Override
    public CommentDto findById(long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return commentMapper.toDto(optionalComment.get());
    }

    @Override
    public List<CommentDto> findAll() {
        List<Comment> commentList = commentRepository.findAll();
        if (commentList.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return commentMapper.toDto(commentList);
    }

    @Override
    public PageDto<CommentDto> findPageByNewsId(long newsId, Pageable pageable) {
        Page<Comment> page = commentRepository.findAllByNewsId(newsId, pageable);
        if (page.isEmpty()) {
            throw new EntityNotFoundException();
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

    @Override
    @Transactional
    public CommentDto update(long id, CreateCommentDto updatedComment) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new EntityNotFoundException();
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
    @Transactional
    public void deleteById(long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new EntityNotFoundException();
        }
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentDto> findAllByNewsId(long id) {
        List<Comment> commentList = commentRepository.findAllByNewsId(id);
        if (commentList.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return commentMapper.toDto(commentList);
    }

    @Override
    @Transactional
    public void deleteAllByNewsId(long newsId) {
        commentRepository.deleteAllByNewsId(newsId);
    }
}
