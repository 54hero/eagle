package org.eagle.annotation;

import java.lang.annotation.*;

/**
 * @author ljj
 * @description 属性注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Field {
    String columnName();

    String type();
}
