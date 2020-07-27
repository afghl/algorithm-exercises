package leetcode;

/**
 * https://leetcode-cn.com/problems/ugly-number/
 *
 * easy
 *
 */
public class 丑数_263 {

    /**
     * 丑数就是只包含质因数 2, 3, 5 的正整数。
     *
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }

        int[] factors = new int[]{2, 3, 5};

        for (int i : factors) {
            while (num % i == 0) {
                num = num / i;
            }
        }

        return num == 1;
    }
}
