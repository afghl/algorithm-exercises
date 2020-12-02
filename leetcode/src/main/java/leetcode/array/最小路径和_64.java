package leetcode.array;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * <p>
 * medium
 */
public class 最小路径和_64 {
    public int minPathSum(int[][] grid) {
        int width = grid[0].length, high = grid.length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 算出来走到grid[i][j]的最小路径

                // 如果在左上角，为当前值
                if (i == 0 && j == 0) {
                    // do nothing.
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }

        return grid[high - 1][width - 1];
    }
}
