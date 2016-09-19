package singleton;

/** 枚举类实现单例
 *  优势：
 *  1.实现简单；
 *  2.JVM层面的线程安全；
 *  3.序列化安全
 *  */
public enum Singleton {
  INSTANCE1;
  
  public void doSomething() {
    System.out.println("Do somegthing...\t");
  }
  
}
