package com.gupao.study.singleton;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class SingletonTest {
    public static void main(String[] args) {
        try {
            // 饿汉式单例会在类加载的时候创建实例
            Class.forName("com.gupao.study.singleton.Hungry");
            System.out.println("Hungry class code load over");
            Class.forName("com.gupao.study.singleton.LazyOne");
            System.out.println("LazyOne class code load over");
            Class.forName("com.gupao.study.singleton.LazyTwo");
            System.out.println("LazyTwo class code load over");
            // 此时LazyThree中的内部类并不会被加载
            Class.forName("com.gupao.study.singleton.LazyThree");
            System.out.println("LazyThree class code load over");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("main begin:");


        Hungry hungry = Hungry.getInstance();
        System.out.println(hungry);

        LazyOne lazyOne = LazyOne.getInstance();
        System.out.println(lazyOne);

        LazyTwo lazyTwo = LazyTwo.getInstance();
        System.out.println(lazyTwo);

        LazyThree lazyThree = LazyThree.getInstance();
        System.out.println(lazyThree);
    }

}
