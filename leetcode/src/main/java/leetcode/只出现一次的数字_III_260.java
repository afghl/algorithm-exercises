package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/single-number-iii/
 *
 * medium
 */
public class 只出现一次的数字_III_260 {
    /**
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> countResult = new HashMap<>();

        for (int num : nums) {
            int count = countResult.getOrDefault(num, 0);

            countResult.put(num, count + 1);
        }

        int[] result = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> e : countResult.entrySet()) {
            if (e.getValue() == 1) {
                result[index++] = e.getKey();
            }
        }

        return result;
    }
}
