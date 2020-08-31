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
        new 第N个数字_400().findNthDigit(6);
        new 第N个数字_400().findNthDigit(44);
        new 第N个数字_400().findNthDigit(1000);
    }

    // 有9个长度为1的数
    // 90个长度为2的数
    // 900个长度为3的数
    // ...

    public int findNthDigit(int n) {
        int weishu = 0;
        int remain = n;

        while (remain - 9 * pow(weishu) > 0) {
            remain = remain - 9 * pow(weishu);
            weishu += 1;
        }

        System.out.println(String.format("remain: %s, weishu: %s", remain, weishu));

        // 算出来有在这个位数下的游标了，再找找这个游标前，一共有几个数
        int count = remain / (weishu + 1);
        System.out.println("count= "+count);


        return -1;
    }

    private int pow(int weishu) {
        return (int) Math.pow(10, weishu);
    }
}
