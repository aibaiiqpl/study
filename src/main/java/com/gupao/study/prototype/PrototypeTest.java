package com.gupao.study.prototype;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p = new Prototype();

        Prototype q = p.clone();

        System.out.println("p==q: "+(p==q));
        System.out.println("p.a == q.a: " +(p.getA() == q.getA()));
        System.out.println("p.var == q.var :" + (p.getVar() == q.getVar()));
        System.out.println("p.map == q.map :" + (p.getMap() == q.getMap()));

        System.out.println("p.var: " + p.getVar());
        System.out.println("q.var: " + q.getVar());

        System.out.println("p.map: " + p.getMap());
        System.out.println("q.map: " + q.getMap());
    }
}
