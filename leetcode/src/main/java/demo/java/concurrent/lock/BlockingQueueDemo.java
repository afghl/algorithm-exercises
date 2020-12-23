package demo.java.concurrent.lock;

import java.util.concurrent.*;

public class BlockingQueueDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(6);

        ExecutorService pool = Executors.newFixedThreadPool(5);

        Future<Integer> future = pool.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "get queue");
            Integer i = queue.poll(3, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "get queue fin.");
            return i;
        });

        pool.submit(() -> {
            Thread.sleep(1000);
            queue.add(5);
            System.out.println(Thread.currentThread().getName() + "add 5");
            return 1;
        });

        System.out.println(future.isDone());

        System.out.println(future.get());

        pool.shutdown();
    }
}
