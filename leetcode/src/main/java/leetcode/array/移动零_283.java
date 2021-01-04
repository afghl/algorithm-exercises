package leetcode.array;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * easy
 */
public class 移动零_283 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // left指向已经处理好的数组的结尾，right向后寻找0的数，和left置换
        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }

            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        new 移动零_283().moveZeroes(new int[] {1,2,0,0});
    }

}
