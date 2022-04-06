package org.eagle.miniPro;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author henry
 */
public class TestPro {

    public void test(@RequestParam("name") String username) {
        System.out.println(username);
    }

    public static void main(String[] args) {
        TestPro test = new TestPro();
        test.test("王者天下");
    }
}
