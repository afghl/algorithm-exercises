package demo.java.concurrent.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    static int count;
    //初始化信号量
    static final Semaphore s
            = new Semaphore(1);

    //用信号量保证互斥
    static void addOne() throws InterruptedException {
        s.acquire();
        try {
            count+=1;
        } finally {
            s.release();
        }
    }
    public static void main(String[] args) {

    }
}
