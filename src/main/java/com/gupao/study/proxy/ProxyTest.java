package com.gupao.study.proxy;

import java.lang.reflect.Proxy;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class ProxyTest {

    public static void main(String[] args) {
        Calculator cal = new CalculatorProxy().newInstance(new CalculatorImpl());
        cal.sum(1, 100);
    }

}
