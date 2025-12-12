package com.jay.cohension.case1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//注解級別：方法注解
@Retention(RetentionPolicy.RUNTIME)//生命周期：運行時
public @interface CustomizedAspect {
}