package java_base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestFixedThreadPool {
  public static void main(String[] args) {
    //ExecutorService es = Executors.newFixedThreadPool(3);
      ExecutorService es = Executors.newCachedThreadPool();
      es.execute(new Task(65));
      es.execute(new Task(5));
      System.out.println("结束执行!");
  }
  
  private static class Task implements Runnable {
    int sec = 0;
    Task(int sec) {
      this.sec = sec;
    }
    
    @Override
    public void run() {
      try {
        TimeUnit.SECONDS.sleep(sec);
        System.out.println("线程" + sec + "秒后退出");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
  }
}
