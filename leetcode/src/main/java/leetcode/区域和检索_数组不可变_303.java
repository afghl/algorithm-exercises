package leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 *
 * easy
 */
public class 区域和检索_数组不可变_303 {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});

        System.out.println(Arrays.toString(numArray.getSums()));
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(0, 5));
        System.out.println(numArray.sumRange(2, 5));
    }

}

class NumArray {

    int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }

    }

    public int[] getSums() {
        return sums;
    }
}