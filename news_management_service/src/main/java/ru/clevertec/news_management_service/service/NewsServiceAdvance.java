package ru.clevertec.news_management_service.service;

import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.dto.NewsCommentsPageWrapperDto;
import ru.clevertec.news_management_service.exception.EntityNotFoundException;

/**
 * @author Andrey Barkovsky
 * @version 1.0
 */
public interface NewsServiceAdvance extends NewsService {

    /**
     * Method for finding wrapper (single news and page of comments) by news id
     *
     * @param id       news id
     * @param pageable arg for comments pagination
     * @return dto with single news and page of comments
     * @throws EntityNotFoundException when news or comments weren't found
     */
    NewsCommentsPageWrapperDto findNewsCommentsPageById(long id, Pageable pageable);

}
