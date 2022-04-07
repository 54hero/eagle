package org.eagle.generics;

import java.util.ArrayList;

/**
 * @author ljj
 * @description 泛型数组
 * 可以声明带泛型的数组引用，但是不能直接创建带泛型的数组对象
 * 可以通过 java.lang.reflect.Array 的 newInstance(Class<T>, int) 来创建 T[] 数组
 */
@SuppressWarnings("all")
public class GenericsArray {

    public static void main(String[] args) {
        ArrayList[] list = new ArrayList[5];
        ArrayList<String>[] lists = list;

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(100);

        list[0] = intList;
        String s = lists[0].get(0);
        System.out.println(s);
    }
}
