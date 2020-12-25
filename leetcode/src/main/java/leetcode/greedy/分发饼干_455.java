package leetcode.greedy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 *
 * easy
 */
public class 分发饼干_455 {
    /**
     * 
     * @param g 孩子的胃口值
     * @param s 每个饼干的尺寸
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int count = 0;

        while (i < g.length && j < s.length) {
            // 如果可满足，也就是s[j] >= g[i]
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}
