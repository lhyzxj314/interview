package design_pattern.singleton;

public class TestSingleton {
  public static void main(String[] args) {
    testSingletonDoubleCheck();
    testSingleton();
    testSingletonLazyLoad();
    testSingletonHungryLoad();
    testSingletonInnerClass();
    testSingletonEnum();
  }

  public static void testSingleton() {
    Singleton.INSTANCE.doSomething();
  }

  public static void testSingletonDoubleCheck() {
    SingletonDoubleCheck instance = SingletonDoubleCheck.getInstance();
    instance.doSomething();
  }

  public static void testSingletonLazyLoad() {
    SingletonLazyLoad instance = SingletonLazyLoad.getInstance();
    instance.doSomething();
  }

  public static void testSingletonHungryLoad() {
    SingletonHungryLoad instance = SingletonHungryLoad.getInstance();
    instance.doSomething();
  }

  public static void testSingletonInnerClass() {
    SingletonInnerClass instance = SingletonInnerClass.getInstance();
    instance.doSomething();
  }

  public static void testSingletonEnum() {
    SingletonEnum instance = SingletonEnum.INSTANCE;
    instance.doSomething();
  }

}
