package leetcode.array;

/**
 * https://leetcode-cn.com/problems/koko-eating-bananas/
 *
 * medium
 */
public class 爱吃香蕉的珂珂_875 {
    public int minEatingSpeed(int[] piles, int H) {
        int min = 1;
        int max = -1;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        while (min < max) {
            int mid = (min + max) / 2;
            if (!possible(piles, H, mid)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    // Can Koko eat all bananas in H hours with eating speed K?
    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles)
            time += (p-1) / K + 1;
        return time <= H;
    }
}
