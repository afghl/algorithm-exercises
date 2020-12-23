package demo.java.concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        int count = 5;
        List<Future<Integer>> futures = new ArrayList<>();
        while (count-- >= 0) {
            Future<Integer> submit = pool.submit(() -> {
                if (1 == 1) {
                    throw new Exception("2");
                }
                return 3;
            });
            futures.add(submit);
        }

        while (!futures.stream().allMatch(Future::isDone));

        futures.forEach(f -> {
            try {
                System.out.println(f.toString());
                Integer integer = f.get();
                System.out.println(integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        pool.shutdown();
    }
}
