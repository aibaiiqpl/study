package com.gupao.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class CalculatorProxy implements InvocationHandler{

    Calculator target = null;

    public Calculator newInstance(Calculator cal){
        target = cal;

        Calculator newCal =(Calculator) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                cal.getClass().getInterfaces(),
                this
        );
        return newCal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin invoke method "+method.getName());
        Long start = System.currentTimeMillis();
        Object obj = method.invoke(target, args);
        Long end = System.currentTimeMillis();
        System.out.println("invoke method over, result="+obj);
        System.out.println("cost time = "+(end-start)+"ms");
        return obj;
    }
}
