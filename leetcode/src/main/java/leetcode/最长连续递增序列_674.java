package leetcode;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 *
 * easy
 *
 */
public class 最长连续递增序列_674 {

    public static void main(String[] args) {
        int length = new 最长连续递增序列_674().findLengthOfLCIS(new int[]{2,2,2,2,2});
        System.out.println(length);
    }

    /**
     * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }
}
