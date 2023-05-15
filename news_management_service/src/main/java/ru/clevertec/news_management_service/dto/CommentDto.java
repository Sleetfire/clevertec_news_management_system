package ru.clevertec.news_management_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.clevertec.news_management_service.dto.serializer.NewsDtoSerializer;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    @JsonProperty("id")
    private long id;
    @JsonProperty("time")
    private LocalDateTime time;
    @JsonProperty("text")
    private String text;
    @JsonProperty("username")
    private String username;
    @JsonProperty("newsId")
    @JsonSerialize(using = NewsDtoSerializer.class)
    private NewsDto news;

}
