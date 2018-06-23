package com.gupao.study.prototype;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class Prototype implements Cloneable, Serializable{

    public String getVar() {
        return var;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public int getA() {
        return a;
    }

    private int a = 123;

    private String var = "prototype";

    private Map<String, Object> map = new ConcurrentHashMap<>();

    public Prototype(){
        map.put("a", 1);
        map.put("b", 2);
    }

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
//        return deepClone();
    }

    protected Prototype deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            try {
                return (Prototype)ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
