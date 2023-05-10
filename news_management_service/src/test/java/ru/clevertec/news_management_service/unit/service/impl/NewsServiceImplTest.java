package ru.clevertec.news_management_service.unit.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.clevertec.news_management_service.mapper.NewsMapper;
import ru.clevertec.news_management_service.repository.NewsRepository;
import ru.clevertec.news_management_service.service.impl.NewsServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class NewsServiceImplTest {

    @MockBean
    private NewsRepository newsRepository;

    @Autowired
    @InjectMocks
    private NewsServiceImpl newsServiceImpl;

    @Autowired
    private NewsMapper newsMapper;

    @Test
    void create() {

    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findPage() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findAllByWordParts() {
    }

    @Test
    void findPageByWordParts() {
    }
}