package leetcode.array;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class 最大子序和_53 {

    public static void main(String[] args) {
        new 最大子序和_53().maxSubArray(new int[] {-3, 1,1,-5,1,4,5});
    }
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];

        // 这里pre是上一个指针所指向的位，以它为结尾的子序和的最大值
        for (int x : nums) {
            // 这里pre是上一个指针所指向的位，以它为结尾的子序和的最大值
            // x是当前的位
            // 意思是如果x加入使之前的结果（pre）> 只以x作为子序列的结果，那么将这个x纳入之前的子序列里
            // 否则，直接以当前x作为一个新的子序列的开始（则将x赋值给pre）
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
