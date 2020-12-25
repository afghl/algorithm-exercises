package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * easy
 */
public class 爬楼梯_70 {

    /**
     * 到n阶台阶的走法数为f(n)
     * 很容易有f(n) = f(n-1) + f(n-2)
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] results = new int[n];

        results[0] = 1;
        results[1] = 2;
        for (int i = 2; i < n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[n - 1];
    }

    public static void main(String[] args) {
        int i = new 爬楼梯_70().climbStairs(3);
        System.out.println(i);
    }
}
