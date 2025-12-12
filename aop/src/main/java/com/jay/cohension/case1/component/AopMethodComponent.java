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
public class AopMethodComponent {

    long start;

    @Pointcut("execution(* com.jay.cohension.case1.AopController.demo1(..)) || execution(* com.jay.cohension.case1.AopController.demo2(..))")
    public void pointcutMethod() {
    }

    @Around("pointcutMethod()")
    public Object doAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("");
        log.info("doAroundMethod");
        log.info("doAround:執行method前");
        //執行業務
        Object result = joinPoint.proceed();

        //系統拋出錯誤，並不會執行以下程式，只會先執行doAfterThrowing() --> doAfter()
        log.info("doAroundMethod:執行method後, response{}", result);
        log.info("");
        return "success";
    }

    @Before("pointcutMethod()")
    //@Before("execution(* org.example.springaop.blog_demo.Controller.*(..))")
    public void doBefore() {
        log.info("doBefore pointcut()");
        start = System.nanoTime();
    }

    @After("pointcutMethod()")
    public void doAfter() {
        log.info("doAfter pointcut()");
        long end = System.nanoTime();
        printExecuteTime(start, end);
    }

    @AfterThrowing(value = "pointcutMethod()", throwing = "throwable")
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
