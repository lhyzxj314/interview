package test_java_spec.NIO;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;

public class TestThread {

    public static int i = 0;
    public static void testCallable() throws ExecutionException, InterruptedException {

        FutureTask<String> ft = new FutureTask<String>(new Callable<String>() {

            @Override
            public String call() throws Exception {
                for (; i < 3; i++) {
                    Thread.sleep(500);
                    System.out.println(i);
                }
                Thread.sleep(5000);
                return "end";
            }
        });
        Thread t1 = new Thread(ft, "t1");
        //t1.start();
        t1.start();
        System.out.println(ft.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testCallable();
    }

}
