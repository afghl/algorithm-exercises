package demo.java.concurrent.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadLocalDemo {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        IntStream.range(1, 5).forEach(a -> {
            pool.submit(() -> {
                threadLocal.set(String.valueOf(a));
                System.out.println(Thread.currentThread().getName() + " set: " + a);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                System.out.println(Thread.currentThread().getName() + " get: " + threadLocal.get());
            });
        });
        pool.awaitTermination(3, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
