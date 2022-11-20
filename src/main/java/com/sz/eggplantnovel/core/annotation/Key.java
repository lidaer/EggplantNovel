package com.sz.eggplantnovel.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 分布式锁-Key 注解
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/20
 */

@Documented
@Retention(RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface Key {
    String expr() default "";
}
