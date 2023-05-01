package ru.clevertec.news_management_service.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.repository.entity.News;

import java.util.List;

@Mapper
public interface NewsMapper {

    NewsDto toDto(News news);

    News toEntity(NewsDto newsDto);

    List<NewsDto> toDto(List<News> newsList);

    List<News> toEntity(List<NewsDto> newsDtoList);

}
