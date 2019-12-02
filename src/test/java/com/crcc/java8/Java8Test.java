package com.crcc.java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java8Test {

    /**
     *
    https://blog.csdn.net/yitian_66/article/details/81010434


    lambda 表达式的语法格式如下：

            (parameters) -> expression或(parameters) ->{statements; }

    以下是lambda表达式的重要特征:

            ·        可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。

            ·        可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。

            ·        可选的大括号：如果主体包含了一个语句，就不需要使用大括号。

            ·        可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
            */

  final static String salutation = "Hello !";
    public static void main(String[] args) {
        Java8Test test = new Java8Test();
        //类型声明
        MathOperation addition = (int a, int b)-> a+b;
        MathOperation subtraction = (int a, int b)-> a-b;

        //大括号中的返回语句
        MathOperation multiplication = (int a,int b)->{
            return a*b;
        };
         //没有大括号及返回语句
        MathOperation division = (int a ,int b)-> a/b;
        System.out.println("10 + 5 = "+test.operation(10,5,addition));
        System.out.println("10 - 5 = "+test.operation(10,5,subtraction));
        System.out.println("10 * 5 = "+test.operation(10,5,multiplication));
        System.out.println("10 / 5 = "+test.operation(10,5,division));

        //不用括号
        GreetingService greetingService = message -> System.out.println("Hello "+message);
        //用括号
        GreetingService greetingService1 = (message) ->
            System.out.println("Hello "+ message);
            greetingService.sayMessage("Runoob");
            greetingService1.sayMessage("Google");

       //----------------------------------------------------
        GreetingService greetingService2 = variableName ->
                System.out.println(salutation+variableName);
        greetingService2.sayMessage("jack");
        //相当于如下
        GreetingService g = new GreetingService() {
            @Override
            public void sayMessage(String message) {
                System.out.println(salutation+message);
            }
        };

        //==========================final=====================================
//        lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有final 的语义）
         int num = 1;
        Convert<Integer,Integer> s = (param)-> System.out.println(String.valueOf(param+num));
        s.convert(2);
//        num =5;
//        在Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
//        String first ="";
        Comparator<String> comparator = (first, second) ->
                System.out.println(Integer.compare(first.length(),second.length()));
        comparator.com("aaaa","bbbbd");

    }

    public interface Comparator<T>{
        void com(String a, String b);
    }

    public interface Convert<T1,T2>{
        void convert(int i);
    }


    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    private int operation(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}




/**
 * 方法引用通过方法的名字来指向一个方法。
 * ::
 */
class Car {
    @FunctionalInterface
    public interface Supplier<T>{
        T get();
    }

    public static Car create(final Supplier<Car> supplier){
        return supplier.get();
    }

    public static void collide(final Car car){
        System.out.println("Collied "+ car.toString());
    }

    public void follow(final Car another){
        System.out.println("Following the "+ another.toString());
    }

    public void repair(){
        System.out.println("Repaired "+ this.toString());
    }

    public static void main(String[] args) {
        //构造器引用： 它的语法是Class::new,或者更一般的Class<T>::new实例如下：
        Car car = Car.create(Car::new);
        Car car1 = Car.create(Car::new);
        Car car2 = Car.create(Car::new);
        Car car3 = new Car();
        List<Car> cars = Arrays.asList(car,car1,car2,car3);
        System.out.println("=================构造器引用==================");
        //静态方法引用：他的语法是  Class::static_method，
        cars.forEach(Car::collide);
        System.out.println("=================静态方法引用==================");

        //特定类的任意方法引用：他的语法是  Class::method，
        cars.forEach(Car::repair);
        System.out.println("=================特定类-任意方法引用==================");

        //特定对象方法引用：他的语法是  instance::method，
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
        System.out.println("=================特定对象-任意方法引用==================");



        List names = new ArrayList();
         names.add("Google");
         names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);

    }

}

/**
 * 3 --
 * 函数式接口(FunctionalInterface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 *
 * 函数式接口可以被隐式转换为lambda表达式。
 *
 * Predicate <T> 接口是一个函数式接口，它接受一个输入参数 T，返回一个布尔值结果。
 *
 * 该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）。
 *
 * 该接口用于测试对象是 true 或 false。
 */


class FunctionTest{
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //Predict<Integer> predicate = n->true
        //n 是一个参数传递到Predicate接口的test方法，n 如果存在则test方法返回true
        System.out.println("输出所有数据");

        //传递参数n
        eval(list,n->true);
        System.out.println("输出所有偶数");
        eval(list,n->n%2==0);

        System.out.println("输出大于3的所有数字");
        eval(list,n->n>3);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate){
        for(Integer n:list){
            if(predicate.test(n)){
                System.out.println(n+"");
            }
        }
    }
}

/**
 * Java 8 新增了接口的默认方法。
 *
 * 简单说，默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法。
 *
 * 我们只需在方法名前面加个default关键字即可实现默认方法。
 *
 * 为什么要有这个特性？
 *
 * 首先，之前的接口是个双刃剑，好处是面向抽象而不是面向具体编程，缺陷是，当需要修改接口时候，需要修改全部实现该接口的类，目前的java 8之前的集合框架没有foreach方法，通常能想到的解决办法是在JDK里给相关的接口添加新的方法及实现。然而，对于已经发布的版本，是没法在给接口添加新方法的同时不影响已有的实现。所以引进的默认方法。他们的目的是为了解决接口的修改与现有的实现不兼容的问题。
 *
 */

//一个接口有默认方法，考虑这样的情况，一个类实现了多个接口，且这些接口有相同的默认方法，以下实例说明了这种情况的解决方法：

interface vehicle{
    default void print(){
        System.out.println("我是一辆车");
    }
}

interface fourWheeler{
    default void print(){
        System.out.println("我是一辆四轮车！");
    }
}

//第一个解决方案是创建自己的默认方法，来覆盖重写接口的默认方法：
class Cars implements vehicle,fourWheeler{

    @Override
    public void print() {
        System.out.println("我就说车！");
    }
}
//第二种解决方案可以使用 super 来调用指定接口的默认方法：

class Cars1 implements vehicle,fourWheeler{

    @Override
    public void print() {
        vehicle.super.print();
    }
}


/**
 * 4.3
 * Java 8 的另一个特性是接口可以声明（并且可以提供实现）静态方法。例如：
 */

interface staticVehicle{
    default void print(){
        System.out.println("我是静态车啊");
    }
    //静态方法
    static void blowHorn(){
        System.out.println("按喇叭！");
    }
}


