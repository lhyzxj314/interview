package java_base;

import java.util.concurrent.TimeUnit;

public class TestFinalize {
  private static TestFinalize SAVE_HOOK;
  
  public void isAlive() {
    System.out.println("对象仍存活....");
  }
  
  @Override
  public void finalize() {
    SAVE_HOOK = this;
    System.out.println("finalize被调用了");
  }
  
  public static void main(String[] args) throws InterruptedException {
    SAVE_HOOK = new TestFinalize();
    
    SAVE_HOOK = null;
    System.gc();
    TimeUnit.MILLISECONDS.sleep(500);
    if (SAVE_HOOK != null) {
      SAVE_HOOK.isAlive();
    } else {
      System.out.println("对象已被销毁!");
    }

    SAVE_HOOK = null;
    System.gc();
    TimeUnit.MILLISECONDS.sleep(500);
    if (SAVE_HOOK != null) {
      SAVE_HOOK.isAlive();
    } else {
      System.out.println("对象已被销毁!");
    }
  }
}
