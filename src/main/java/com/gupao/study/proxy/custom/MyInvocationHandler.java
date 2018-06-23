package com.gupao.study.proxy.custom;

import java.lang.reflect.Method;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
