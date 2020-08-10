package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 卡牌分组_914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> numCounts = new HashMap<>();

        for (int i : deck) {
            if (numCounts.containsKey(i)) {
                numCounts.put(i, numCounts.get(i) + 1);
            } else {
                numCounts.put(i, 1);
            }
        }

        numCounts.values();
        return false;
    }
}
