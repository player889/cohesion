# AOP Module

This module demonstrates various ways to implement Aspect-Oriented Programming (AOP) using Spring AOP.

## Overview

The AOP module showcases different pointcut expressions and advice types:

- **Method-based Pointcuts:** Targeting specific methods in a controller.
- **Annotation-based Pointcuts:** Targeting methods annotated with a custom annotation.
- **Advice Types:** `@Before`, `@After`, `@Around`, and `@AfterThrowing`.

## Stack

- Spring Boot Starter Web
- Spring Boot Starter AOP
- Lombok

## Entry Point

- `com.jay.cohension.AopApplication`: The main Spring Boot application class.

## Endpoints (Case 1)

These endpoints are defined in `AopController` to demonstrate AOP behavior:

- **`GET /demo1`**: Demonstrates a standard method-based pointcut.
- **`GET /demo2`**: Demonstrates AOP behavior when an exception is thrown (`@AfterThrowing`).
- **`GET /demo3`**: Demonstrates an annotation-based pointcut using `@CustomizedAspect`.

## AOP Components

- **`AopMethodComponent`**: Handles AOP for `/demo1` and `/demo2`.
- **`AopAnnotationComponent`**: Handles AOP for `/demo3` using the `@CustomizedAspect` annotation.

## How to Test

You can use the provided `.http` file to test the endpoints:

- `aop/src/main/resources/case1.http`

Or use `curl`:

```bash
curl http://localhost:8080/demo1
curl http://localhost:8080/demo2
curl http://localhost:8080/demo3
```

## Scripts

- `mvn spring-boot:run`: Run the application.

## TODOs

- [ ] Add more complex AOP examples (e.g., parameter validation).
- [ ] Implement unit tests for AOP aspects.