package org.eagle.annotation;

import java.lang.annotation.*;

/**
 * @author ljj
 * @description 表注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    String value() default "";
}
