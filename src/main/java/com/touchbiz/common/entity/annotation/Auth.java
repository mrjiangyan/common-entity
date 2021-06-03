package com.touchbiz.common.entity.annotation;

import java.lang.annotation.*;

/**
 * @author steven
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Auth {

    String[] roles() default "";
}