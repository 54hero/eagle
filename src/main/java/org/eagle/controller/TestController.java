package org.eagle.controller;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author henry
 */
public class TestController {

    public void test(@RequestParam("name") String username) {
        System.out.println(username);
    }

    public static void main(String[] args) {
        TestController test = new TestController();
        test.test("王者天下");
    }
}
