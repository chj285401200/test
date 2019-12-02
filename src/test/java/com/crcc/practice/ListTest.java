package com.crcc.practice;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTest {

    //list 12345689删除偶数

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1,2,3,4,5,6,8,9).collect(Collectors.toList());

        rmList(list);
//        rmStream(list);
        System.out.println(list);
    }


    private static List<Integer> rmList(List<Integer> list){
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            if(it.next()%2==0)
                it.remove();
        }
        return list;
    }

    private static List<Integer> rmStream(List<Integer> list){
        List<Integer> collect = list.stream().filter(s -> s % 2 != 0).collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }

}
