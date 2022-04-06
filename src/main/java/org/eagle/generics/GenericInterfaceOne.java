package org.eagle.generics;

/**
 * @author ljj
 * @description 泛型接口的实现类，不是泛型类，必须固定泛型类型
 */
@SuppressWarnings("all")
public class GenericInterfaceOne implements GenericInterface<String> {

    @Override
    public String getTest() {
        return null;
    }

    @Override
    public void setTest(String test) {

    }
}
