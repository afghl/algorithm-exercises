package leetcode;

/**
 * https://leetcode-cn.com/problems/kth-missing-positive-number/
 * <p>
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-missing-positive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 第_k_个缺失的正整数_1539 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 7, 11};
        findKthPositive(arr, 5);
    }

    /**
     * 严格升序， 那么当前数组上的值(arr[i])和下标(i)之间的差值就是缺了的数的个数
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] - i - 1 >= k) {
                return k + i;
            }
        }
        return k + n;
    }
}
