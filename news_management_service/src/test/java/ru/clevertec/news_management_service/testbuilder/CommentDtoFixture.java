package ru.clevertec.news_management_service.testbuilder;

import ru.clevertec.news_management_service.dto.CommentDto;

import java.util.ArrayList;
import java.util.List;

public class CommentDtoFixture {

    public static final CommentDto COMMENT_DTO = new CommentDtoBuilder().build();

    public static List<CommentDto> getCommentDtoList(int commentCount) {
        List<CommentDto> commentDtoList = new ArrayList<>();
        for (int i = 0; i < commentCount; i++) {
            CommentDto commentDto = new CommentDtoBuilder()
                    .withId(i + 1)
                    .build();
            commentDtoList.add(commentDto);
        }
        return commentDtoList;
    }

}
