package org.eagle.generics;

/**
 * @author ljj
 * @description 子类如果是泛型类，那么它的泛型标识<T>必须和父类一致，即使子类做了泛型扩展，也必须保证子类泛型标识中有一个与父类一致
 */
public class ChildOne<T,E,K,V> extends Parent<T> {
}
