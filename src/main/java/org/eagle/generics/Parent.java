package org.eagle.generics;

/**
 * @author ljj
 * @description 泛型：类型参数化
 */
@SuppressWarnings("all")
public class Parent<T> {
    private T parent;

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }
}
