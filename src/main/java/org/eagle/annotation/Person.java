package org.eagle.annotation;

import java.lang.annotation.*;

/**
 * @author ljj
 * @description 注入人员信息
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Person {
    String value() default "";
}
