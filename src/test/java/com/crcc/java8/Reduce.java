package com.crcc.java8;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reduce {


    @Test
    public void testReduce(){

        /**
         * stream  只可以被使用一次就关闭了。
         *         Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
         */

        List<Integer> list = Stream.of(1,2,3,4,5,6,7,8).collect(Collectors.toList());
        //求和
        Integer result = list.stream().reduce(0,Integer::sum);
        System.out.println(result);

        //求和
        list.stream().reduce((i, j) -> i + j).ifPresent(System.out::println);

        //求最大值
        list.stream().reduce(Integer::max).ifPresent(System.out::println);
        //求最小值
        list.stream().reduce(Integer::min).ifPresent(System.out::println);

        //做逻辑,,最小值
        list.stream().reduce((i, j) -> i > j ? j : i).ifPresent(System.out::println);
        //求逻辑求乘机
         int result2 = list.stream().filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);

         Optional.of(result2).ifPresent(System.out::println);
    }


    @Test
    public void reduceList() {

        List<Student> list = new ArrayList<>();
        Student student1 = new Student(1,new Score(80,"语文"));
        Student student2 = new Student(1,new Score(90,"数学"));
        Student student3 = new Student(2,new Score(100,"English"));

        list.add(student1);
        list.add(student2);
        list.add(student3);

        //使用Reduce 将所有的所有的成绩进行加和
        Optional<Score> totalScore = list.stream()
                .map(Student::getScore)
                .reduce((x, y) -> x.add(y));
        System.out.println(totalScore.get().getPoint()); }

                //@Test public void reduceList2() { List<Student> list = getStudents(); Student student = getStudent(); //使用Reduce 求 list 、student 的总成绩之和 Score scoreSum = list.stream() .map(Student::getScore) //相当于加了一个初始值 .reduce(student.getScore(), (x, y) -> x.add(y)); System.out.println(scoreSum.getPoint()); } private Student getStudent() { Student student = new Student(); student.setId(4); Score score = new Score(); score.setPoint(100); student.setScore(score); return student; } private List<Student> getStudents() { List<Student> list = new ArrayList<>(); for (int i = 0; i < 3; i++) { Student stu = new Student(); Score score = new Score(); score.setPoint(80); score.setCourseName("English"); stu.setId(i); stu.setScore(score); list.add(stu); } return list; }

}


 class Student {

    private Integer id;

    //课程分数
    private Score score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    Student(Integer id,Score score){
    this.id=id;
    this.score=score;
    }
 }



 class Score {

    //分数
    private Integer point;

    //课程名称
    private String courseName;

    public Integer getPoint() {
        return point;
    }

    public Score add(Score other) {

        this.point += other.getPoint();

        return this;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    Score(Integer point,String courseName){
        this.point = point;
        this.courseName = courseName;
    }
}
