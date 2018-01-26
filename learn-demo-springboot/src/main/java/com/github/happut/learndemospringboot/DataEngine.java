package com.github.happut.learndemospringboot;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface DataEngine {
    String value() default "";
    String engine() default "";
}
