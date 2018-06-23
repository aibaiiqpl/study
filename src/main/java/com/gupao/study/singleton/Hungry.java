package com.gupao.study.singleton;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/17
 */
public class Hungry {
    private Hungry (){
        System.out.println("Hungry instance constructed");
    }

    private static Hungry instance = new Hungry();

    public static Hungry getInstance() {
        return instance;
    }
}
