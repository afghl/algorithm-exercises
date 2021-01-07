package demo.java.concurrent.synchronizedemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class 线程互斥demo {

    static volatile boolean printOdd = true;

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        ExecutorService pool = Executors.newFixedThreadPool(2);

        // 基数
        pool.submit(() -> {
            int i = 0;
            synchronized (lock) {
                while (i < 50) {
                    while (!printOdd) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(2 * i + 1);
                    printOdd = false;
                    i++;
                    lock.notify();
                }
            }
        });

        // 偶数
        pool.submit(() -> {
            int i = 1;
            synchronized (lock) {
                while (i <= 50) {

                    while (printOdd) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(i * 2);
                    printOdd = true;
                    i++;
                    lock.notify();
                }
            }
        });

//        pool.shutdown();
    }
}
