package leetcode.array;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * easy
 */
public class 合并两个有序数组_88 {

    /**
     * 1. 有序
     * 2. 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int fillIndex = nums1.length - 1;

        // 从后向前遍历
        while (p >= 0 && q >= 0) {
            if (nums1[p] > nums2[q]) {
                nums1[fillIndex--] = nums1[p--];
            } else {
                nums1[fillIndex--] = nums2[q--];
            }
        }

        System.arraycopy(nums2, 0, nums1, 0, q + 1);
    }
}
