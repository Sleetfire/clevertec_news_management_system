package ru.clevertec.news_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.news_management_service.repository.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}
