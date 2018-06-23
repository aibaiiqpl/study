package com.gupao.study.singleton;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class SingletonPerformanceTest {
    public static void main(String[] args) {
        Long start = null;
        Long end = null;

        Integer loopSize = 1000000;
        System.out.println("begin: ");

        start = System.currentTimeMillis();
        for(int i = 0; i< loopSize; i++){
            LazyOne.getInstance();
        }
        end = System.currentTimeMillis();
        System.out.println("LazyOne : "+(end-start));

        start = System.currentTimeMillis();
        for(int i = 0; i< loopSize; i++){
            LazyTwo.getInstance();
        }
        end = System.currentTimeMillis();
        System.out.println("LazyTwo : "+(end-start));


        start = System.currentTimeMillis();
        for(int i = 0; i< loopSize; i++){
            LazyThree.getInstance();
        }
        end = System.currentTimeMillis();
        System.out.println("LazyThree : "+(end-start));


    }
}
