package com.gupao.study.proxy.custom;

import com.gupao.study.proxy.Calculator;

import java.lang.reflect.Method;


/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class MyCalculatorProxy implements MyInvocationHandler {
    Calculator target = null;

    public Calculator newInstance(Calculator cal){
        target = cal;

        Calculator newCal =(Calculator) MyProxy.newProxyInstance(
                new MyClassLoader(),
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
