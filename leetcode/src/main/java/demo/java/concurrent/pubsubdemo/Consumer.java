package demo.java.concurrent.pubsubdemo;

public class Consumer {

    public void process(Data data) {
        try {
            Thread.sleep(5000L);
            System.out.println("[consumer] " + Thread.currentThread().getName() + "process data fin." + data);
        } catch (InterruptedException e) {
        }
    }
}
