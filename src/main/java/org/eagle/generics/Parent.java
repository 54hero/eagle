package org.eagle.generics;

/**
 * @author ljj
 */
public class Parent<T> {
    private T parent;

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }
}