package leetcode.pending;

/**
 * https://leetcode-cn.com/problems/candy/
 * hard
 */
public class 分发糖果_135 {
    public int candy(int[] ratings) {
        if (ratings == null) {
            return 0;
        }

        int[] result = new int [ratings.length];

        for (int i = 1; i < ratings.length - 1; i++) {
            int prev = ratings[i - 1];
            int curr = ratings[i];
            int next = i < ratings.length - 1 ? ratings[i + 1] : 0;

        }
        return result[ratings.length - 1];
    }
}
