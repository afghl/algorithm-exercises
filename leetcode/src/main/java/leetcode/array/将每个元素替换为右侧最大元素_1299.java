package leetcode.array;

/**
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 *
 * easy
 */
public class 将每个元素替换为右侧最大元素_1299 {

    /**
     * 你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
     * 完成所有替换操作后，请你返回这个数组。
     *
     * 示例：
     *
     * 输入：arr = [17,18,5,4,6,1]
     * 输出：[18,6,6,6,1,-1]
     *
     */
    public int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] result = new int[arr.length];

        int index = arr.length - 1;
        int max = -1;
        while (index >= 0) {
            result[index] = max;
            max = Math.max(max, arr[index]);
            index--;
        }
        return result;
    }
}
