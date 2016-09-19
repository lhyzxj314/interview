package singleton;

public class Test {
  public static void main(String[] args) {
    System.out.println(Singleton.INSTANCE1);
    Singleton.INSTANCE1.doSomething();
  }
}
