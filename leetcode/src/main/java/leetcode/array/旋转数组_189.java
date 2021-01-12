package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * medium
 */
public class 旋转数组_189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        boolean[] rotated = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (rotated[i]) {
                continue;
            }

            // 放到i + k的位置，然后将i + k的位置的数，拿出来
            int next = (i + k) % nums.length;
            int num = nums[i];
            while (!rotated[next]) {
                int nextNum = nums[next];
                nums[next] = num;
                rotated[next] = true;
                num = nextNum;
                next = (next + k) % nums.length;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7};
        new 旋转数组_189().rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
