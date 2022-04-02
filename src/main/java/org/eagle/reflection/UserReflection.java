package org.eagle.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ljj
 * @description 用户反射
 */
public class UserReflection {

    private final static Logger logger = LoggerFactory.getLogger(UserReflection.class);

    public void userHandler(String className) {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
