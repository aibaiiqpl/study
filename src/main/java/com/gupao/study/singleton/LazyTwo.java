package com.gupao.study.singleton;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class LazyTwo {
    private static LazyTwo instance = null;

    private LazyTwo(){
        System.out.println("LazyThree instance constructed");
    }


    public synchronized static LazyTwo getInstance(){
        if(instance == null){
            instance = new LazyTwo();
        }
        return instance;
    }
}
