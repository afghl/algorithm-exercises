package demo.java.concurrent.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(100);

        pool.execute(() -> {
            System.out.println("park: " + Thread.currentThread().getName());
            LockSupport.park(new Object());
            System.out.println("after park");
        });
        pool.execute(() -> {
            System.out.println("sout: "+ Thread.currentThread().getName());
            System.out.println(1);
        });
        pool.execute(() -> {
            try {
                lock.lock();
                System.out.println("sleep: "+ Thread.currentThread().getName());
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(() -> {
            try {
                lock.lock();
                System.out.println("get lock sleep: "+ Thread.currentThread().getName());
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.execute(() -> {
            try {
                new Object().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        pool.execute(TestThread::syncMethod);
//        pool.execute(TestThread::syncMethod);
        System.out.println("" + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
    }

    private static synchronized void syncMethod() {
        try {
            Thread.sleep(100000);
        } catch (Exception e) {}

    }
}
