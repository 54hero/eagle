package org.eagle.lambda;

/**
 * @author ljj
 */
@SuppressWarnings("all")
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.add(Integer::sum));

        System.out.println(test.add((arge1, arge2) -> {
            return arge1 + arge2;
        }));
    }

    public int add(NmFunction function) {
        int a = 10;
        int b = 20;
        return function.test(a, b);
    }
}
