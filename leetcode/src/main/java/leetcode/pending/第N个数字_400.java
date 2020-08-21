package leetcode.pending;

/**
 * https://leetcode-cn.com/problems/nth-digit/
 *
 * mid
 */
/**
 * 输入:
 * 11
 *
 * 输出:
 * 0
 *
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 *
 */
public class 第N个数字_400 {

    public static void main(String[] args) {
        new 第N个数字_400().findNthDigit(9);
        new 第N个数字_400().findNthDigit(100);
        new 第N个数字_400().findNthDigit(1000);
    }

    // 有9个长度为1的数
    // 90个长度为2的数
    // 900个长度为3的数
    // ...

    public int findNthDigit(int n) {

        int weishu = 1;

        int remain = n;

        while (remain > 0) {
            remain = n - 9 * pow(weishu);
            weishu += 1;
        }

        System.out.println(String.format("remain: %s, weishu: %s", remain, weishu));

        return -1;
    }

    private int pow(int weishu) {
        return (int) Math.pow(10, weishu -1);
    }
}
