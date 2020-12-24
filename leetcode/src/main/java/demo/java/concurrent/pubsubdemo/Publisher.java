package demo.java.concurrent.pubsubdemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Publisher {

    private BlockingQueue<Data> q = new LinkedBlockingQueue<>();
    ExecutorService producerPool = Executors.newFixedThreadPool(2);
    ExecutorService consumerPool = Executors.newFixedThreadPool(10);


}
