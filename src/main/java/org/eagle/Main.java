package org.eagle;

import org.eagle.annotation.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author ljj
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        // 获取 Class 对象
        final Class<?> clazz = Class.forName("org.eagle.entity.Hero");

        // 获取注解
        final Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获取注解的 value 值
        final Table table = clazz.getAnnotation(Table.class);
        System.out.println(table.value());

        // 获取类指定的注解
        final Field name = clazz.getDeclaredField("age");
        final org.eagle.annotation.Field field = name.getAnnotation(org.eagle.annotation.Field.class);
        System.out.println(field.columnName());
        System.out.println(field.type());
    }
}
