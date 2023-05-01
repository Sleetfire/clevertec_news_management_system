package ru.clevertec.news_management_service.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.news_management_service.dto.CreateNewsDto;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;
import ru.clevertec.news_management_service.service.NewsService;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<NewsDto> create(@Valid @RequestBody CreateNewsDto news) {
        return new ResponseEntity<>(newsService.create(news), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<NewsDto> findById(@PathVariable long id) {
        return new ResponseEntity<>(newsService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<NewsDto>> findAll() {
        return new ResponseEntity<>(newsService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/page", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PageDto<NewsDto>> findPage(@RequestParam(defaultValue = "0", required = false) int page,
                                                     @RequestParam(defaultValue = "1", required = false) int size) {
        if (page < 0) {
            throw new RuntimeException();
        }
        if (size < 1) {
            throw new RuntimeException();
        }
        Pageable pageable = PageRequest.of(page, size);

        return new ResponseEntity<>(newsService.findPage(pageable), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<NewsDto> update(@PathVariable long id, @RequestBody CreateNewsDto updatedNews) {
        return new ResponseEntity<>(newsService.update(id, updatedNews), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        newsService.deleteById(id);
    }


}
