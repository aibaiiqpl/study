package com.gupao.study.singleton;

import java.io.Serializable;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class Seriable implements Serializable{
    private final static Seriable INSTANCE = new Seriable();
    private Seriable(){

    }

    public static Seriable getInstance() {
        return INSTANCE;
    }


    private Object readResolve(){
        return INSTANCE;
    }

}
