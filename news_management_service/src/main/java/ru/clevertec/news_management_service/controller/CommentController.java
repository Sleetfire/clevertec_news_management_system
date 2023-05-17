package ru.clevertec.news_management_service.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.CreateCommentDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.service.CommentService;

import java.util.List;

import static ru.clevertec.news_management_service.controller.util.ControllerUtil.*;

@RestController
@RequestMapping("/api/v1/news")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/{newsId}/comments",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CommentDto> create(@PathVariable long newsId, @RequestBody CreateCommentDto comment) {
        return new ResponseEntity<>(commentService.create(newsId, comment), HttpStatus.CREATED);
    }

    @GetMapping(value = "/comments/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CommentDto> findById(@PathVariable long id) {
        return new ResponseEntity<>(commentService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/comments", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CommentDto>> findAll() {
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{newsId}/comments", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CommentDto>> findAllByNewsId(@PathVariable long newsId) {
        return new ResponseEntity<>(commentService.findAllByNewsId(newsId), HttpStatus.OK);
    }

    @GetMapping(value = "/{newsId}/comments/page", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PageDto<CommentDto>> findPageByNewsId(@PathVariable long newsId,
                                                                @RequestParam(defaultValue = "0", required = false) int page,
                                                                @RequestParam(defaultValue = "1", required = false) int size) {

        Pageable pageable = getPageable(page, size);
        return new ResponseEntity<>(commentService.findPageByNewsId(newsId, pageable), HttpStatus.OK);
    }

    @PatchMapping(value = "/comments/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CommentDto> update(@PathVariable long id, @RequestBody CreateCommentDto updatedComment) {
        return new ResponseEntity<>(commentService.update(id, updatedComment), HttpStatus.OK);
    }

    @DeleteMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        commentService.deleteById(id);
    }

    @DeleteMapping(value = "/{newsId}/comments")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllByNewsId(@PathVariable long newsId) {
        commentService.deleteAllByNewsId(newsId);
    }

}
