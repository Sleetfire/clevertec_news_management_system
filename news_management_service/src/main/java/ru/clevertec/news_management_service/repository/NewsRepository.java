package ru.clevertec.news_management_service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.clevertec.news_management_service.repository.entity.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    @Query("select n from News n where n.title like ?1 or n.text like ?1")
    List<News> findAllByWordParts(String wordParts);

    @Query("select n from News n where n.title like ?1 or n.text like ?1")
    Page<News> findAllByWordParts(String wordParts, Pageable pageable);

}
