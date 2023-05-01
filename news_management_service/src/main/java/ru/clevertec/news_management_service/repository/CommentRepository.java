package ru.clevertec.news_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.news_management_service.repository.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
