package org.eagle.generics;

/**
 * @author ljj
 * @description 类型通配符，用于集合
 * 类型通配符一般是使用 "?" 代替具体类型实参
 * 所以，类型通配符是类型实参，而不是类型形参
 * 【类型通配符的上限】<? extends Number>，要求该泛型的类型，只能上限类型，或者上限类型的子类型
 * 【类型通配符的下线】<? super Integer>，要求该泛型的类型，只能是下限类型，或者下限类型的父类型
 * 类型通配符
 */
public class Sign<E> {
}
