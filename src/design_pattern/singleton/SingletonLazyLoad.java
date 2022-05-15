package design_pattern.singleton;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

/**
 * 单例模式——懒汉式
 * 是否线程安全：可选
* */
public class SingletonLazyLoad {

    private static SingletonLazyLoad INSTANCE;

    private SingletonLazyLoad() {

    }

    // 线程不安全
   public static SingletonLazyLoad getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonLazyLoad();
        }
        return INSTANCE;
    }


    // 线程安全，但多线程调用时效率低下
    /*public static synchronized SingletonLazyLoad getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonLazyLoad();
        }
        return INSTANCE;
    }*/


    public void doSomething() {
        System.out.println("Instance is doing Something...");
    }

}
