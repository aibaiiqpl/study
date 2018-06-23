package com.gupao.study.singleton;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/17
 */
public class LazyOne {

    private static LazyOne instance = null;

    private LazyOne(){
        System.out.println("LazyOne instance constructed");
    }


    public static LazyOne getInstance(){
        if(instance == null){
            instance = new LazyOne();
        }
        return instance;
    }
}
