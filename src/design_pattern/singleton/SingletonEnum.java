package design_pattern.singleton;

/**
 * 单例模式——枚举类
 * */
public enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("Instance is doing Something...");
    }
}
