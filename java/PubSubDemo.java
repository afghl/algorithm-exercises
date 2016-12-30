import java.nio.file.Watchable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PubSubDemo {
    public static void main(String[] args) {
        new Restaurant().run();
    }
}

class Restaurant {
    ExecutorService service;
    ConcurrentLinkedQueue<Meal> q;

    public void run() {
        service = Executors.newCachedThreadPool();
        q = new ConcurrentLinkedQueue();
        for (int i = 0; i < 1; i++) {
            Waiter waiter = new Waiter(q);
            service.execute(waiter);
        }
        for (int i = 0; i < 2; i++) {
            Cook cook = new Cook(q);
            service.execute(cook);
        }
    }
}

class Cook implements Runnable {
    ConcurrentLinkedQueue<Meal> q;
    static AtomicInteger mealCount = new AtomicInteger(1);

    public Cook(ConcurrentLinkedQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Meal m = new Meal(mealCount.incrementAndGet());
                q.add(m);
                System.out.println("create meal: " + m);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Waiter implements Runnable {
    ConcurrentLinkedQueue<Meal> q;

    public Waiter(ConcurrentLinkedQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Meal m = null;
                while (m == null) m = q.poll();
                System.out.println("---  deliver meal: " + m);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Meal {
    int id;
    public Meal(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "";
    }
}