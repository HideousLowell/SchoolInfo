package ru.eshakin.schoolinfo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoggingAspect.class);
    /**
     * Pointcut that matches all repositories, services and Web REST endpoints.
     */
    @Pointcut("execution(* ru.eshakin.schoolinfo.service.GenericService.*(..))")
    public void anyService() {
    }

    @Around("anyService()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed();
        log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), result);
        return result;
    }
}