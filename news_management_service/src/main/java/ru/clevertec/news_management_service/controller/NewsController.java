package ru.clevertec.news_management_service.controller;

import jakarta.validation.Valid;
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
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.news_management_service.dto.CreateNewsDto;
import ru.clevertec.news_management_service.dto.NewsCommentsPageWrapperDto;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.service.NewsServiceAdvance;

import java.util.List;

import static ru.clevertec.news_management_service.controller.util.ControllerUtil.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsServiceAdvance newsServiceAdvanceImpl;

    public NewsController(NewsServiceAdvance newsServiceAdvanceImpl) {
        this.newsServiceAdvanceImpl = newsServiceAdvanceImpl;
    }

    @PostMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<NewsDto> create(@Valid @RequestBody CreateNewsDto news) {
        return new ResponseEntity<>(newsServiceAdvanceImpl.create(news), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<NewsDto> findById(@PathVariable long id) {
        return new ResponseEntity<>(newsServiceAdvanceImpl.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<NewsDto>> findAll() {
        return new ResponseEntity<>(newsServiceAdvanceImpl.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/page", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PageDto<NewsDto>> findPage(@RequestParam(defaultValue = "0", required = false) int page,
                                                     @RequestParam(defaultValue = "1", required = false) int size) {

        Pageable pageable = getPageable(page, size);

        return new ResponseEntity<>(newsServiceAdvanceImpl.findPage(pageable), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<NewsDto> update(@PathVariable long id, @RequestBody CreateNewsDto updatedNews) {
        return new ResponseEntity<>(newsServiceAdvanceImpl.update(id, updatedNews), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        newsServiceAdvanceImpl.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{id}/comments/wrapper")
    public ResponseEntity<NewsCommentsPageWrapperDto> findWrapper(@PathVariable long id,
                                                                  @RequestParam(defaultValue = "0", required = false) int page,
                                                                  @RequestParam(defaultValue = "1", required = false) int size) {

        Pageable pageable = getPageable(page, size);

        return new ResponseEntity<>(newsServiceAdvanceImpl.findNewsCommentsPageById(id, pageable), HttpStatus.OK);
    }

}
