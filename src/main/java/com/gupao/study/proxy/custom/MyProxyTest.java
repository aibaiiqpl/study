package com.gupao.study.proxy.custom;

import com.gupao.study.proxy.Calculator;
import com.gupao.study.proxy.CalculatorImpl;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class MyProxyTest {
    public static void main(String[] args) {
        Calculator cal =new MyCalculatorProxy().newInstance(new CalculatorImpl());
        cal.add(7,3);
    }
}
