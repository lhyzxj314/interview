package design_pattern.singleton;

/**
 * 单例模式——饿汉式
 *  是否线程安全：是
 *
 * */
public class SingletonHungryLoad {

    private static SingletonHungryLoad INSTANCE = new SingletonHungryLoad();

    private SingletonHungryLoad() {

    }

    public static SingletonHungryLoad getInstance() {
        return INSTANCE;
    }

    public void doSomething() {
        System.out.println("Instance is doing Something...");
    }

}
