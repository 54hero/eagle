package org.eagle.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ljj
 */
public class Lambda {

    public static void main(String[] args) {

        String str = " Error ";

        final List<String> collect1 = Arrays.stream(str.split(",")).collect(Collectors.toList());

        List<String> key = new ArrayList<>();
        key.add("name");
        key.add("age");
        key.add("gender");

        List<String> value = new ArrayList<>();
        value.add("henry");
        value.add("24");
        value.add("male");

        final Map<String, String> collect = key.stream().collect(Collectors.toMap(e -> e, e -> value.get(key.indexOf(e))));

        System.out.println(collect);
    }
}
