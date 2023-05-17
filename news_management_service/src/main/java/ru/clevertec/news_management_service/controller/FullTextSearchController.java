package ru.clevertec.news_management_service.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.NewsCommentsDtoWrapper;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.service.FullTextSearchService;

import java.util.List;

import static ru.clevertec.news_management_service.controller.util.ControllerUtil.*;

@RestController
@RequestMapping(value = "/api/v1/search")
public class FullTextSearchController {

    private final FullTextSearchService fullTextSearchServiceImpl;

    public FullTextSearchController(FullTextSearchService fullTextSearchServiceImpl) {
        this.fullTextSearchServiceImpl = fullTextSearchServiceImpl;
    }

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<NewsCommentsDtoWrapper>> find(@RequestParam(required = false, defaultValue = "") String text) {
        return new ResponseEntity<>(fullTextSearchServiceImpl.find(text), HttpStatus.OK);
    }

    @GetMapping(value = "/news", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<NewsDto>> findNewsList(@RequestParam(required = false, defaultValue = "") String text) {
        return new ResponseEntity<>(fullTextSearchServiceImpl.findNewsList(text), HttpStatus.OK);
    }

    @GetMapping(value = "/news/page", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PageDto<NewsDto>> findNewsPage(@RequestParam(required = false, defaultValue = "") String text,
                                                         @RequestParam(defaultValue = "0", required = false) int page,
                                                         @RequestParam(defaultValue = "1", required = false) int size) {

        Pageable pageable = getPageable(page, size);

        return new ResponseEntity<>(fullTextSearchServiceImpl.findNewsPage(text, pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/comments", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CommentDto>> findCommentList(@RequestParam(required = false, defaultValue = "") String text) {
        return new ResponseEntity<>(fullTextSearchServiceImpl.findCommentList(text), HttpStatus.OK);
    }

    @GetMapping(value = "/comments/page", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PageDto<CommentDto>> findCommentPage(@RequestParam(required = false, defaultValue = "") String text,
                                                               @RequestParam(defaultValue = "0", required = false) int page,
                                                               @RequestParam(defaultValue = "1", required = false) int size) {

        Pageable pageable = getPageable(page, size);

        return new ResponseEntity<>(fullTextSearchServiceImpl.findCommentPage(text, pageable), HttpStatus.OK);
    }
}
