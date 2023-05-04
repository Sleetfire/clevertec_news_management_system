package ru.clevertec.news_management_service.controller.util;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.clevertec.news_management_service.exception.IllegalRequestParamException;


@UtilityClass
public class ControllerUtil {

    public static Pageable getPageable(int page, int size) {

        if (page < 0) {
            throw new IllegalRequestParamException();
        }
        if (size < 1) {
            throw new IllegalRequestParamException();
        }

        return PageRequest.of(page, size);
    }

}
