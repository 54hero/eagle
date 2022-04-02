package org.eagle.reflection;

import org.eagle.entity.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ljj
 * @description 用户反射
 */
public class UserReflection {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取 Class 对象
        final Class<?> clazz = Class.forName("org.eagle.entity.User");

        // 构造一个对象
        final Constructor<?> constructor = clazz.getDeclaredConstructor(Integer.class, String.class, Integer.class);
        final User henry = (User) constructor.newInstance(111, "henry", 12);
        System.out.println("===================================");
        System.out.println(henry);
        System.out.println("===================================");

        // 通过反射调用方法
        // 使用 invoke 调用方法，激活，执行
        // 参数：哪个对象 和 调用的参数
        final Method setName = clazz.getDeclaredMethod("setName", String.class);
        setName.invoke(henry,"stark");
        System.out.println("===================================");
        System.out.println(henry);
        System.out.println("===================================");
    }
}
