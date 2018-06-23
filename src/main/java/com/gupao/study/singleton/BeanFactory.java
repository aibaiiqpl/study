package com.gupao.study.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class BeanFactory {

    private BeanFactory(){

    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String name){
        if(!ioc.containsKey(name)){
            try {
                Object obj = Class.forName(name).newInstance();
                return ioc.put(name, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            return ioc.get(name);
        }
        return null;
    }
}
