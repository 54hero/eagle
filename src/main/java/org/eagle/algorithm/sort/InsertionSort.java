package org.eagle.algorithm.sort;

import java.util.List;

/**
 * @author ljj
 */
public class InsertionSort {

    public static void func(List<Integer> arr) {
        int preIndex;
        int current;
        for (int i = 0; i < arr.size(); i++) {
            preIndex = i - 1;
            current = arr.get(i);
            while (preIndex >= 0 && arr.get(preIndex) > current) {
                arr.set(i, arr.get(preIndex));
                preIndex--;
            }
            arr.set(preIndex + 1, current);
        }
    }
}
