package org.eagle.miniPro;

/**
 * @author henry
 */
public class TestPro {

    public void test(String username) {
        System.out.println(username);
    }

    public static void main(String[] args) {
        TestPro test = new TestPro();
        test.test("王者天下");
    }
}
