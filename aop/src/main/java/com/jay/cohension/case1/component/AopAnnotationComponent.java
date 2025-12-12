package com.jay.cohension.case1.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@Aspect
public class AopAnnotationComponent {

    long start;

    @Pointcut("execution(* com.jay.cohension.case1.AopController.demo3(..))")
    public void pointcutAnnotation() {
    }

    @Around("@annotation(com.jay.cohension.case1.CustomizedAspect)")
    public Object doAroundAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("");
        log.info("doAroundAnnotation");
        Object result = joinPoint.proceed();
        log.info("doAroundAnnotation:執行method後, response{}", result);
        log.info("");
        return "success";
    }

    @Before("pointcutAnnotation()")
    //@Before("execution(* org.example.springaop.blog_demo.Controller.*(..))")
    public void doBefore() {
        log.info("doBefore pointcut()");
        start = System.nanoTime();
    }

    @After("pointcutAnnotation()")
    public void doAfter() {
        log.info("doAfter pointcut()");
        long end = System.nanoTime();
        printExecuteTime(start, end);
    }

    @AfterThrowing(value = "pointcutAnnotation()", throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        log.info("doAfterThrowing,throwable:{}", throwable.getMessage());
    }

    private void printExecuteTime(long start, long end) {
        long durationNs = end - start;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String formatted = LocalTime.MIDNIGHT.plusNanos(durationNs).format(fmt);
        log.info("執行時間: {}", formatted);
    }

}
