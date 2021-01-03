package leetcode.math;

/**
 * https://leetcode-cn.com/problems/maximum-swap/
 *
 * medium
 */
public class 最大交换_670 {

    /**
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     *
     * 示例 1 :
     *
     * 输入: 2736
     * 输出: 7236
     * 解释: 交换数字2和数字7。
     * 示例 2 :
     *
     * 输入: 9973
     * 输出: 9973
     * 解释: 不需要交换。
     *
     */
    public int maximumSwap(int num) {
        if (num <= 0) {
            return num;
        }

        char[] chars = String.valueOf(num).toCharArray();

        // 因为你要考虑98368 这种数字，这个应该输出98863
        // 保存一堆的最大值的位置，maxIndex[i]就是i位之后（包括i位）最大值的下标
        int[] maxIndex = new int[chars.length];
        int maxI = chars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            int integer = toInt(chars[i]);
            int max = toInt(chars[maxI]);

            if (integer > max) {
                maxI = i;
            }
            maxIndex[i] = maxI;
        }

        // 比如98368这个数，maxIndex就是[0,4,4,4,4]
        // 9973，maxIndex 就是[1，1，2，3]
        // 然后从前向后找，找可以换的，然后置换
        for (int i = 0; i < chars.length; i++) {
            int integer = toInt(chars[i]);
            int max = toInt(chars[maxIndex[i]]);

            if (integer < max) {
                // swap
                chars[i] = (char) (max + '0');
                chars[maxIndex[i]] = (char) (integer + '0');
                break;
            }
        }

        return Integer.parseInt(new String(chars));
    }

    private int toInt(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        System.out.println(new 最大交换_670().maximumSwap(9973));
    }
}