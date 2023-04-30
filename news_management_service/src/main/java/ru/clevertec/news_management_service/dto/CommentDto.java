package ru.clevertec.news_management_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    private long id;
    private LocalDateTime time;
    private String text;
    private String username;
    private NewsDto news;

}
