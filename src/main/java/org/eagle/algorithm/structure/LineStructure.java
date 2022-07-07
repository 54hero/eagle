package org.eagle.algorithm.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author ljj
 */
public class LineStructure {

    public static void main(String[] args) {
        String regex = "\\b+?\\w+?-\\w+?-\\w+?-\\w+?\\b+?";
        Pattern pattern = Pattern.compile(regex);

        List<String> list = new ArrayList<>();
        list.add(" 23-234-54-23 ");
        list.add(" 342-432jk32-343-232");
        list.add(" 3478-324-56-456");
        list.add("543-654-435-23");

        final List<String> collect = list.stream().filter(s -> pattern.matcher(s).find()).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
