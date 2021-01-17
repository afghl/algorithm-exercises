package demo.java.concurrent.lock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();

        map.put("1", "2");

        int[] result = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }
}
