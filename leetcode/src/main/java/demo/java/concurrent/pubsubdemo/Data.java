package demo.java.concurrent.pubsubdemo;

import java.util.concurrent.atomic.AtomicInteger;

public class Data {
    private static final AtomicInteger total = new AtomicInteger();
    private int id;

    public Data() {
        id = total.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Data{ count: " + id + "}";
    }
}
