package leetcode.array;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * <p>
 * medium
 */
public class 寻找重复数_287 {

    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,4,2,2]
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [3,1,3,4,2]
     * 输出: 3
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return -1;
    }

    public int findDuplicate2(int[] nums) { }

}
