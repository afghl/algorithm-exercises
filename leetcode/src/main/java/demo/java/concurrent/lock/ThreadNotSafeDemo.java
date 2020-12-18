package demo.java.concurrent.lock;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadNotSafeDemo {

    /**
     * 一个arrayList线程不安全的case
     *
     * 用copyOnWriteArrayList，使得它变成线程安全
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(100);
        int count = 10000;
        List<Future> futures = new ArrayList<>();
        while (count > 0) {

            Future<?> submit = pool.submit(() -> {
                list.add(new Random().nextInt());
            });
            futures.add(submit);
            count--;
        }

        System.out.println(futures.size());
        System.out.println(list.size());

        Thread.sleep(5000);
        System.out.println(futures.stream().allMatch(Future::isDone));
        System.out.println(list.size());
//        futures.forEach(future -> {future.});
    }
}
