package com.crcc.reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reduce8 {


    public static void main(String[] args) {
        testMultiReduce();
    }



    private static void testMultiReduce() {
        ArrayList<List<String>> strings = new ArrayList<>();
        strings.add(Arrays.asList("1", "2", "3", "4"));
        strings.add(Arrays.asList("2", "3", "4", "5"));
        strings.add(Arrays.asList("3", "4", "5", "6"));

        // 非并行流
        Integer reduce1 = strings.stream().flatMap(e -> e.stream()).reduce(0,
                (acc, e) -> acc + Integer.valueOf(e), (u, t) -> {
                    // 非并行流，不会执行第三个参数
                    System.out.println("u----:" + u);
                    // 这里的返回值并没有影响返回结果
                    return null;
                });
        System.out.println("reduce1:" + reduce1);

        // 并行流
        Integer reduce2 = strings.parallelStream().flatMap(e -> e.stream()).reduce(0,
                (acc, e) -> acc + Integer.valueOf(e), (u, t) -> {
                    // u，t分别为并行流每个子任务的结果
                    System.out.println("u----:" + u);
                    System.out.println("t----:" + t);
                    return u + t;
                });
        System.out.println("reduce2:" + reduce2);
    }
}
