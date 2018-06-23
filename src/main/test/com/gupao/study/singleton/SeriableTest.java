package com.gupao.study.singleton;

import java.io.*;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class SeriableTest {
    public static void main(String[] args) {
        Seriable s1 = null;
        Seriable s2 = Seriable.getInstance();

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(s2);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = null;

            ois = new ObjectInputStream(bis);
            s1 = (Seriable) ois.readObject();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
