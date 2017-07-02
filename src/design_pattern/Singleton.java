package design_pattern;

/**
 * 枚举实现单例模式
 * @author xshrimp
 * 2017年7月2日
 */
public enum Singleton {
  INSTANCE;
  
  public void doSomething() {
    System.out.println("instance is doing something...");
  }
}
/*public enum Singleton {
  INSTANCE;
  
  private Resource instance;
  private Singleton() {
    instance = new Resource();
  }
  
  public Resource getInstance() {
    return instance;
  }
  
}*/

class Resource {
  private int field;
  
  public void setField(int value) {
    field = value;
  }
  
  public int getField() {
    return field;
  }
}



