package org.eagle.reflection;

import org.eagle.annotation.Person;

/**
 * @author ljj
 * @description 用户反射
 */
public class UserReflection {


    public static void userHandler(String className) {
        try {
            final Class<?> userClass = Class.forName(className);
            System.out.println(userClass);
            System.out.println(userClass.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("反射异常 ----> " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        UserReflection.userHandler("org.eagle.entity.User");
    }
}
