package com.gupao.study.singleton;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class LazyThree {
    private static boolean initialized = false;

    private LazyThree(){
        // 这里可以防止反射侵入
        synchronized (LazyThree.class){
            if(!initialized){
                initialized = true;
                System.out.println("LazyThree instance constructed");
            }else{
                throw new RuntimeException("单例已被创建");
            }
        }
    }


    public  static LazyThree getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyThree LAZY = new LazyThree();
    }

}
