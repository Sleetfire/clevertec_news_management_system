package ru.clevertec.news_management_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNewsDto {

    @NotBlank(message = "Title cannot be null")
    private String title;

    @NotBlank(message = "Text cannot be null")
    private String text;
}
