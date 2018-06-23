package com.gupao.study.proxy;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class CalculatorImpl implements Calculator{
    @Override
    public Integer add(Integer a, Integer b){
        return a+b;
    }

    @Override
    public Integer sum(Integer from, Integer to){
        return (from+to) * (to-from + 1) / 2;
    }
}
