package ru.clevertec.news_management_service.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments", schema = "news_management_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime time;
    private String text;
    private String username;

    @ManyToOne
    @JoinColumn(nullable = false, name = "news_id")
    private News news;

}
