package ru.clevertec.news_management_service.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.service.Cache;
import ru.clevertec.news_management_service.service.CacheFactory;

@Component
public class CacheFactoryImpl implements CacheFactory {

    @Value("${cache.type}")
    private String cacheType;

    @Value("${cache.capacity}")
    private int capacity;

    @Override
    public Cache<Long, NewsDto> getNewsCache() {
        return switch (cacheType) {
            case "LFU" -> new LFUCache<>(capacity);
            case "LRU" -> new LRUCache<>(capacity);
            default -> null;
        };
    }

    @Override
    public Cache<Long, CommentDto> getCommentCache() {
        return switch (cacheType) {
            case "LFU" -> new LFUCache<>(capacity);
            case "LRU" -> new LRUCache<>(capacity);
            default -> null;
        };
    }
}
