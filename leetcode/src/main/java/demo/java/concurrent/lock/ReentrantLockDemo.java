package demo.java.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {



    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        lock.lock();
        try {
            System.out.println("aquired lock");
        } finally {
            lock.unlock();
            lock.unlock();
        }

    }
}
