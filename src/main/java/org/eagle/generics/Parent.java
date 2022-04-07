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

    /**
     * 【泛型方法】支持可变参数
     * @param e
     * @param <E>
     * @return
     */
    public static <E> E test(E... e) {
        return null;
    }
}
