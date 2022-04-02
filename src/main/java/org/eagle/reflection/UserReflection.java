package org.eagle.reflection;

import org.eagle.entity.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ljj
 * @description 用户反射
 */
public class UserReflection {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取 Class 对象
        final Class<?> clazz = Class.forName("org.eagle.entity.User");

        // 构造一个对象
        final Constructor<?> constructor = clazz.getConstructor(Integer.class, String.class, Integer.class);
        final User henry = (User) constructor.newInstance(111, "henry", 12);
        System.out.println("===================================");
        System.out.println(henry);
        System.out.println("===================================");

        // 通过反射调用方法

    }

    public static void userHandler(String className) {
        try {
            final Class<?> userClass = Class.forName(className);
            System.out.println(userClass);
            System.out.println(userClass.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("反射异常 ----> " + e.getMessage());
        }
    }
}
