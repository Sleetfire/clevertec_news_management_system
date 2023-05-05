package ru.clevertec.news_management_service.service;

import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.NewsCommentsPageWrapperDto;

public interface NewsServiceAdvance extends NewsService {

    NewsCommentsPageWrapperDto findNewsCommentsPageById(long id, Pageable pageable);

}
