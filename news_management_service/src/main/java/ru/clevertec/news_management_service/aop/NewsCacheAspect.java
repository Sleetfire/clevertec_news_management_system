package ru.clevertec.news_management_service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.clevertec.news_management_service.dto.NewsDto;
import ru.clevertec.news_management_service.service.Cache;
import ru.clevertec.news_management_service.service.CacheFactory;

import java.util.Objects;
import java.util.Optional;

@Aspect
@Component
public class NewsCacheAspect {

    private final Cache<Long, NewsDto> newsCache;

    public NewsCacheAspect(CacheFactory cacheFactory) {
        newsCache = cacheFactory.getNewsCache();
    }

    @Pointcut("execution(* ru.clevertec.news_management_service.service.impl.NewsServiceAdvanceImpl.create(*))")
    public void addNewsMethod() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("execution(* ru.clevertec.news_management_service.service.impl.NewsServiceAdvanceImpl.findById(*))")
    public void findNewsMethod() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("execution(* ru.clevertec.news_management_service.service.impl.NewsServiceAdvanceImpl.update(..))")
    public void updateNewsMethod() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("execution(void ru.clevertec.news_management_service.service.impl.NewsServiceAdvanceImpl.deleteById(*))")
    public void deleteNewsMethod() {
        throw new UnsupportedOperationException();
    }

    @AfterReturning(pointcut = "addNewsMethod() || updateNewsMethod()", returning = "retVal")
    public Object addOrUpdateNewsToCache(Object retVal) {
        NewsDto newsDto = (NewsDto) retVal;
        if (Objects.nonNull(newsDto)) {
            long id = newsDto.getId();
            newsCache.add(id, newsDto);
        }
        return newsDto;
    }

    @Around(value = "findNewsMethod()")
    public Object findNewsInCache(ProceedingJoinPoint joinPoint) throws Throwable{
        long id = (long) joinPoint.getArgs()[0];
        Optional<NewsDto> optionalNewsDto = newsCache.get(id);
        if (optionalNewsDto.isEmpty()) {
            NewsDto newsDto = (NewsDto) joinPoint.proceed();
            newsCache.add(id, newsDto);
            return newsDto;
        }
        return optionalNewsDto.get();
    }

    @After(value = "deleteNewsMethod()")
    public void deleteNewsInCache(JoinPoint joinPoint) {
        long id = (long) joinPoint.getArgs()[0];
        newsCache.delete(id);
    }

}
