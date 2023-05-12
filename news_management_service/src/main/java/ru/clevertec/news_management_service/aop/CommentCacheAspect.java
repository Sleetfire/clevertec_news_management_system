package ru.clevertec.news_management_service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.clevertec.news_management_service.dto.CommentDto;
import ru.clevertec.news_management_service.service.Cache;
import ru.clevertec.news_management_service.service.CacheFactory;

import java.util.Objects;
import java.util.Optional;

@Aspect
@Component
public class CommentCacheAspect {

    private final Cache<Long, CommentDto> commentCache;

    public CommentCacheAspect(CacheFactory cacheFactory) {
        commentCache = cacheFactory.getCommentCache();
    }

    @Pointcut("execution(* ru.clevertec.news_management_service.service.impl.CommentServiceImpl.create(..))")
    public void addCommentMethod() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("execution(* ru.clevertec.news_management_service.service.impl.CommentServiceImpl.findById(*))")
    public void findCommentMethod() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("execution(* ru.clevertec.news_management_service.service.impl.CommentServiceImpl.update(..))")
    public void updateCommentMethod() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("execution(void ru.clevertec.news_management_service.service.impl.CommentServiceImpl.deleteById(*))")
    public void deleteCommentMethod() {
        throw new UnsupportedOperationException();
    }

    @AfterReturning(pointcut = "addCommentMethod() || updateCommentMethod()", returning = "retVal")
    public Object addOrUpdateCommentToCache(Object retVal) {
        CommentDto commentDto = (CommentDto) retVal;
        if (Objects.nonNull(commentDto)) {
            long id = commentDto.getId();
            commentCache.add(id, commentDto);
        }
        return commentDto;
    }

    @Around(value = "findCommentMethod()")
    public Object findNewsInCache(ProceedingJoinPoint joinPoint) throws Throwable {
        long id = (long) joinPoint.getArgs()[0];
        Optional<CommentDto> optionalCommentDto = commentCache.get(id);
        if (optionalCommentDto.isEmpty()) {
            CommentDto commentDto = (CommentDto) joinPoint.proceed();
            commentCache.add(id, commentDto);
            return commentDto;
        }
        return optionalCommentDto.get();
    }

    @After(value = "deleteCommentMethod()")
    public void deleteNewsInCache(JoinPoint joinPoint) {
        long id = (long) joinPoint.getArgs()[0];
        commentCache.delete(id);
    }
}
