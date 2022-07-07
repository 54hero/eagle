package org.eagle.algorithm.sort;

import java.util.List;

/**
 * @author ljj
 */
public class BubbleSort {

    public static void func(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                if (arr.get(j) > arr.get(j+1)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }
}
