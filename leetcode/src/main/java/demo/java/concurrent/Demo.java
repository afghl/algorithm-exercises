package demo.java.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = exeSomeAsyncTasks(pool, 3, 5);
        System.out.printf("current thread try to get calculate result: %s %n", Thread.currentThread().getName());

        for (Future<Integer> future : futures) {
            try {
                while (true) {
                    if (future.isDone() && !future.isCancelled()) {
                        System.out.println("Future:" + future
                                + ",Result:" + future.get());
                        break;
                    } else {
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();
    }

    private static List<Future<Integer>> exeSomeAsyncTasks(ExecutorService pool, int a, int b) {
        Future<Integer> future1 = pool.submit(() -> {
            sleep(5000L);
            return a + b;
        });

        Future<Integer> future2 = pool.submit(() -> {
            sleep(5000L);
            return a - b;
        });

        Future<Integer> future3 = pool.submit(() -> {
            sleep(5000L);
            return a * b;
        });

        return Arrays.asList(future1, future2, future3);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
