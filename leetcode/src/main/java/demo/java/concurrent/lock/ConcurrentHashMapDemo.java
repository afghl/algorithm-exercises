package demo.java.concurrent.lock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();

        map.put("1", "2");
    }
}
