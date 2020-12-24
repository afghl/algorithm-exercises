package demo.java.concurrent.pubsubdemo;

import java.util.List;
import java.util.concurrent.*;

public class Demo {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService producerPool = Executors.newFixedThreadPool(2);
        BlockingQueue<Data> q = new LinkedBlockingQueue<>();

        producerPool.submit(() -> {
            Producer producer = new Producer();
            while (true) {
                Data data = producer.produce();
                q.offer(data);
            }
        });

        producerPool.submit(() -> {
            Producer producer = new Producer();
            while (true) {
                Data data = producer.produce();
                q.offer(data);
            }
        });

        ExecutorService consumerPool = Executors.newFixedThreadPool(10);
        int count = 20;
        while (count-- > 0) {
            consumerPool.submit(() -> {
                Consumer c = new Consumer();
                while (true) {
                    Data data = q.take();
                    c.process(data);
                }
            });
        }
    }
}

