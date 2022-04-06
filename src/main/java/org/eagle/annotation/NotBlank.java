package org.eagle.annotation;

import java.lang.annotation.*;

/**
 * @author henry
 * @description 非空判断
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {
}
