package leetcode.array;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class 删除排序数组中的重复项_26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        new 删除排序数组中的重复项_26().removeDuplicates(nums);
    }

    /*
            约束：1. 有序

         */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int p = 0, q = 1;

        // 双指针，一个标记p记录当前已经完成改造的下标，一个标记q记录整个数组已经被遍历的长度。
        while (q < nums.length) {
            // 找到和nums[p]不相同的nums[q]的下标
            if (nums[p] < nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }

        return p + 1;
    }

}
