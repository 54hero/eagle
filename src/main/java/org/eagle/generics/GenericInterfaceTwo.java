package org.eagle.generics;

/**
 * @author ljj
 * @description 泛型接口的实现类，是泛型类，【实现类的泛型标识】必须包含【泛型类的标识】
 */
@SuppressWarnings("all")
public class GenericInterfaceTwo<K,E,T,V> implements GenericInterface<T> {
    @Override
    public T getTest() {
        return null;
    }

    @Override
    public void setTest(T test) {

    }
}
