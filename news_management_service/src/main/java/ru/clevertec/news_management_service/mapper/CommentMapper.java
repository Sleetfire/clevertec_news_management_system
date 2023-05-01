package ru.clevertec.news_management_service.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.repository.entity.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {

    CommentDto toDto(Comment comment);

    Comment toEntity(CommentDto commentDto);

    List<CommentDto> toDto(List<Comment> commentList);

    List<Comment> toEntity(List<CommentDto> commentDtoList);

}
