package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 * medium
 */
public class 三角形最小路径和_120 {

    /**
     * 这里不能用贪心，因为无法证明到第n层的最小，往下走到终点也能最小。
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // 求到所有节点的最小路径，然后求到最后一层，比较所有路径的最小值。
        // min(n, k) = min(n - 1, k - 1)和min(n - 1, k)的最小值 + tri(n, k)

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        List<List<Integer>> minimums = new ArrayList<>();
        minimums.add(triangle.get(0));
        for (int n = 1; n < triangle.size(); n++) {
            List<Integer> preCounts = minimums.get(n - 1);
            List<Integer> level = triangle.get(n);
            List<Integer> minimumCounts = new ArrayList<>();
            for (int k = 0; k < level.size(); k++) {
                int currMinCount;
                if (k == 0) {
                    currMinCount = preCounts.get(k) + level.get(k);
                } else if (k == level.size() - 1) {
                    currMinCount = preCounts.get(k - 1) + level.get(k);
                } else {
                    currMinCount = Math.min(preCounts.get(k - 1), preCounts.get(k)) + level.get(k);
                }
                minimumCounts.add(currMinCount);
            }
            minimums.add(minimumCounts);
        }

        List<Integer> lastLevel = minimums.get(triangle.size() - 1);
        lastLevel.sort(Comparator.comparingInt(a -> a));
        return lastLevel.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new 三角形最小路径和_120().minimumTotal(Arrays.asList(
                Arrays.asList(-1),
                Arrays.asList(-2, -3)
        )));
    }
}
