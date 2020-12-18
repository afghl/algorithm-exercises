package demo.java.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThrowExceptionDemo {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(100);

        try {
            pool.execute(() -> {
                throw new RuntimeException("exception");
            });
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
