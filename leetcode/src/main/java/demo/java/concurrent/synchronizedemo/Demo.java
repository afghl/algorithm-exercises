package demo.java.concurrent.synchronizedemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Lock lock = new ReentrantLock();
        Condition aFinish = lock.newCondition();
        Condition bFinish = lock.newCondition();
        Condition cFinish = lock.newCondition();
        AtomicInteger state = new AtomicInteger(1);
        // job a
        pool.submit(() -> {
            try {
                lock.lock();
                while (!(state.get() == 1))
                    cFinish.await();
                System.out.println(Thread.currentThread().getName() + "a get lock.");
                System.out.println(Thread.currentThread().getName() + " processing a.");
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " process a finish.");
                state.set(2);
                aFinish.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        // job b
        pool.submit(() -> {
            try {
                lock.lock();
                while (!(state.get() == 2))
                    aFinish.await();
                System.out.println(Thread.currentThread().getName() + "b get lock.");

                System.out.println(Thread.currentThread().getName() + " processing b.");
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " process b finish.");
                state.set(3);
                bFinish.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        // job c
        pool.submit(() -> {
            try {
                lock.lock();
                while (!(state.get() == 3))
                    bFinish.await();
                System.out.println(Thread.currentThread().getName() + "c get lock.");


                System.out.println(Thread.currentThread().getName() + " processing c.");
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " process c finish.");
                state.set(1);
                cFinish.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        System.out.println(11);
    }

    private static void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
