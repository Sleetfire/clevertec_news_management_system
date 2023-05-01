package ru.clevertec.news_management_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCommentDto {

    @NotBlank(message = "Text cannot be null")
    private String text;

    @NotBlank(message = "Username cannot be null")
    private String username;
    private long newsId;
}
