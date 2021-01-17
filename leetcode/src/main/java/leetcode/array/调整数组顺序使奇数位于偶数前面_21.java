package leetcode.array;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * easy
 */
public class 调整数组顺序使奇数位于偶数前面_21 {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        int l = 0, r = nums.length - 1;

        while(l < r) {

            // 对于l，找到要移动的下标（也就是偶数）
            while (nums[l] % 2 != 0 && l < nums.length - 1) l++;
            // 对于r，找到基数
            while (nums[r] % 2 == 0 && r > 0) r--;

            if (l < r) {
                // swap
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            }
        }

        return nums;
    }
}
