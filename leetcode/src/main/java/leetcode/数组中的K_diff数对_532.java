package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/
 *
 * easy
 *
 */
public class 数组中的K_diff数对_532 {


    public int findPairs(int[] nums, int k) {
        int count = 0;
        Set<Integer> sums = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] - nums[j] == k) || (nums[j] - nums[i] == k)) {
                    int sum = nums[i] + nums[j];
                    if (sums.contains(sum)) {
                        continue;
                    }

                    sums.add(sum);
                    count++;
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        new 数组中的K_diff数对_532().findPairs(new int[]{1,2,3,4,5}, -1);
    }
}
