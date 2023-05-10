package ru.clevertec.news_management_service.testbuilder;

import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.dto.PageDto;

import java.util.ArrayList;
import java.util.List;

public class NewsDtoFixture {

    public static final NewsDto NEWS_DTO = new NewsDtoBuilder().build();

    public static List<NewsDto> getNewsDtoList(int newsCount) {
        List<NewsDto> newsDtoList = new ArrayList<>();
        for (int i = 0; i < newsCount; i++) {
            NewsDto newsDto = new NewsDtoBuilder()
                    .withId(i)
                    .build();
            newsDtoList.add(newsDto);
        }
        return newsDtoList;
    }

}
