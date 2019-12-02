package com.crcc.java8;


/**
 * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
 *
 * Stream使用一种类似用SQL语句从数据库查询数据的直观方式来提供一种对Java集合运算和表达的高阶抽象。
 *
 * Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
 *
 * 这种风格将要处理的元素集合看作一种流，流在管道中传输，并且可以在管道的节点上进行处理，比如筛选，排序，聚合等。
 *
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * 5.1什么是 Stream？
 * Stream（流）是一个来自数据源的元素队列并支持聚合操作
 *
 * 元素：是特定类型的对象，形成一个队列。Java中的Stream并不会存储元素，而是按需计算。
 *
 * 数据源 ：流的来源。可以是集合，数组，I/O channel，产生器generator等。
 *
 * 聚合操作： 类似SQL语句一样的操作，比如filter, map, reduce, find,match, sorted等。
 *
 * 和以前的Collection操作不同，Stream操作还有两个基础的特征：
 *
 * Pipelining:：中间操作都会返回流对象本身。这样多个操作可以串联成一个管道，如同流式风格（fluent style）。这样做可以对操作进行优化，比如延迟执行(laziness)和短路( short-circuiting)。
 *
 * 内部迭代：以前对集合遍历都是通过Iterator或者For-Each的方式,显式的在集合外部进行迭代，这叫做外部迭代。Stream提供了内部迭代的方式，通过访问者模式(Visitor)实现。
 */
public class Java8Stream {
    /**
     * 5.2生成流
     * 在Java 8中,集合接口有两个方法来生成流：
     *
     * stream() −为集合创建串行流。
     *
     * parallelStream() − 为集合创建并行流。
     */

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        List<String> filtered = strings.stream().filter(string->
                !string.isEmpty()).collect(Collectors.toList());
        String mergedString = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串"+mergedString);
        /**
         * foreach
          */
//        strings.forEach(System.out::println);
//        filtered.forEach(System.out::println);
        /**
         * limit 方法用于获取指定数量的流。以下代码片段使用 limit 方法打印出 10 条数据：
         */
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        /**
         * map
         */
        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
        //获取对应的平方数
        List<Integer> squareList = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
//        squareList.forEach(System.out::println);

        /**
         * filter 方法用于通过设置条件过滤出元素。以下代码片段使用filter 方法过滤出空字符串：
         * 获取空字符串数量
         */
        int count = (int) strings.stream().filter(string->string.isEmpty()).count();
        System.out.println(count);
        /**
         * limit 方法用于获取指定数量的流。以下代码片段使用 limit 方法打印出 10 条数据：
         * sorted 方法用于对流进行排序
         */
        numbers.stream().sorted(Comparator.reverseOrder());
//        random.ints().limit(10).sorted().forEach(System.out::println);
        random.ints().limit(10).sorted().forEach(System.out::println);

/**
 * parallelStream 是流并行处理程序的代替方法。以下实例我们使用parallelStream 来输出空字符串的数量：
 */

        long parallelCount = strings.parallelStream().filter(string->string.isEmpty()).count();

        /**
         * 统计
         */
        IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("最大数： "+intSummaryStatistics.getMax());
        System.out.println("平均数： "+intSummaryStatistics.getAverage());
        System.out.println("数量： "+intSummaryStatistics.getCount());
        System.out.println("最小数： "+intSummaryStatistics.getMin());
        System.out.println("和： "+intSummaryStatistics.getSum());
    }




}
