package demo.java.concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolDemo2 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        int count = 10;
        while (count-- >= 0) {
            pool.submit(() -> {
                System.out.println(1);
                try {
                    Thread.sleep(4000L);
                } catch (Exception e) {

                }
            });
        }
        System.out.println(pool);
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.SECONDS);

    }
}
