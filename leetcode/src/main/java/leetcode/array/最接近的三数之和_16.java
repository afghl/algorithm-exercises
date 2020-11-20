package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * <p>
 * medium
 */
public class 最接近的三数之和_16 {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
     * <p>
     * 约束：假定每组输入只存在唯一答案。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0, 1, 2},0));
    }
}
