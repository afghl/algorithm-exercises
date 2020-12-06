package leetcode.array;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * easy
 */
public class 两个数组的交集_349 {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * 示例 2：
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     *  
     *
     * 说明：
     *
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // 排序 + 双指针
        int ptr1 = 0, ptr2 = 0;
        List<Integer> intersection = new ArrayList<>();
        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                if (!intersection.contains(nums1[ptr1])) {
                    intersection.add(nums1[ptr1]);
                }

                ptr1++;
                ptr2++;
            } else if (nums1[ptr1] < nums2[ptr2]){
                ptr1++;
            } else {
                ptr2++;
            }
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        new 两个数组的交集_349().intersection(new int[] {1,2,2,1}, new int[] {2,2});
    }
}
