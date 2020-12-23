package demo.java.concurrent.lock;


import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

class ObjPool<T, R> {
    final List<T> pool;
    // 用信号量实现限流器
    final Semaphore sem;

    // 构造函数
    ObjPool(int size, T t) {
        pool = new Vector<T>() {
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    // 利用对象池的对象，调用func
    R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) {
//        // 创建对象池
//        ObjPool<Long, String> pool =
//                new ObjPool<Long, String>(10, 2);
//        // 通过对象池获取t，之后执行
//        pool.exec(t -> {
//            System.out.println(t);
//            return t.toString();
//        });

        List<Integer> l = Arrays.asList(1, 2, 3);
        l.add(4);
    }
}

