package com.crcc.test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1,2,3,4,6,7,8).collect(Collectors.toList());

        Set<Integer> collect = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet());

        System.out.println(collect);
    }


}
