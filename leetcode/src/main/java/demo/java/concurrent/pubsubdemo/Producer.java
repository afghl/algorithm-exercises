package demo.java.concurrent.pubsubdemo;

import java.util.concurrent.Callable;

public class Producer {
    public Data produce() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
        }
        Data data = new Data();
        System.out.println("-----[producer]" + Thread.currentThread().getName() + " produce data fin." + data);
        return data;
    }
}
