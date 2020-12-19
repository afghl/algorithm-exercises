package leetcode.math;

/**
 * https://leetcode-cn.com/problems/powx-n/
 *
 * medium
 */
public class Powx_n_50 {

    // 2^10 = 4^5 = 16^2 * 4^1
    public double myPow(double x, int n) {
        if (n < 0) {
            return doPow(1 / x, -n);
        } else {
            return doPow(x, n);
        }
    }

    public double doPow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            return doPow(x * x, n / 2);
        } else {
            return doPow(x * x, n / 2) * doPow(x, 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Powx_n_50().myPow(1.00000, -2147483648));
    }
}
