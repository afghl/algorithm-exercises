package leetcode.array;

/**
 * https://leetcode-cn.com/problems/guess-numbers/
 *
 * easy
 */
public class 猜数字_LCP_01 {

    public int game(int[] guess, int[] answer) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }

        return count;
    }
}
