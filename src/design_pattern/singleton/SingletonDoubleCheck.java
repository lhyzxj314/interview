package design_pattern.singleton;

/**
 * 双重校验锁方式实现单例模式
 * */
public class SingletonDoubleCheck {

    private volatile static SingletonDoubleCheck INSTANCE;

    private SingletonDoubleCheck() {

    }

    public static SingletonDoubleCheck getInstance() {
        if (INSTANCE == null) {
            synchronized(SingletonDoubleCheck.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }

    public void doSomething() {
        System.out.println("Instance is doing something...");
    }

}
