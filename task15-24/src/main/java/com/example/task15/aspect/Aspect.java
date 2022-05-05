package com.example.task15.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start =System.currentTimeMillis();

        Object proceed=joinPoint.proceed();

        long executionTime=System.currentTimeMillis()-start;

        log.info(joinPoint.getSignature().getName()+" executed in "+executionTime+"ms");
        return proceed;
    }
}