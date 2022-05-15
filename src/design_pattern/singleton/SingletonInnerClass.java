package design_pattern.singleton;

/**
 * 单例模式——内部类
 * 是否线程安全：是
 * 是否延迟初始化：是
 * */
public class SingletonInnerClass {

    private SingletonInnerClass() {

    }

    private static class SingletonHolder {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void doSomething() {
        System.out.println("Instance is doing Something...");
    }

}
