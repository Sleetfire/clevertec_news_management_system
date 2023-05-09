package ru.clevertec.news_management_service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restControllerClassMethods() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void serviceClassMethods() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositoryClassMethods() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("restControllerClassMethods() || serviceClassMethods() || repositoryClassMethods()")
    public void restControllerServiceMethods() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("@annotation(ru.clevertec.news_management_service.aop.annotation.Loggable)")
    public void loggableAnnotatedMethods() {}

    @Around("restControllerClassMethods()")
    public Object logRequestResponse(ProceedingJoinPoint joinPoint) throws Throwable {

        ResponseEntity<?> result = (ResponseEntity<?>) joinPoint.proceed();
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();

        logger.info("Method signature: {}. Args list: {}. Return value: {}. Status code: {}",
                signature, args, result.getBody(), result.getStatusCode());
        return result;
    }

    @AfterThrowing(value = "restControllerServiceMethods()", throwing = "exception")
    public void logControllerException(JoinPoint joinPoint, Exception exception) {

        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        String exceptionName = exception.getClass().getName();
        String exceptionMessage = exception.getMessage();

        logger.warn("Method signature: {}. Args list: {}. Exception name type: {}. Exception message: {}",
                signature, args, exceptionName, exceptionMessage);
    }

    @Around("loggableAnnotatedMethods()")
    public Object logStateChangedMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();

        Object result = joinPoint.proceed();

        logger.info("Method signature: {}. Args list: {}. Result: {} {}", signature, args, methodName, result);
        return result;
    }

}
