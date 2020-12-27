package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/maximal-rectangle/
 * <p>
 * hard
 */
public class 最大矩形_85 {
    public int maximalRectangle(char[][] matrix) {
        // 定义v[i][j]和h[i][j]记录纵向和横向的边长
        // 定义v[i][j]为matrix[i][j]的为下端点的最大长度
        // 定义h[i][j]为matrix[i][j]的为右端点的最大长度
        // area[i][j] = v[i][j] * h[i][j]

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] v = new int[matrix.length][matrix[0].length];
        int[][] h = new int[matrix.length][matrix[0].length];
        int ans = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int curr = toInt(matrix[i][j]);
                if (i == 0 && j == 0) {
                    v[i][j] = curr;
                    h[i][j] = curr;
                } else if (i == 0) {
                    v[i][j] = curr;
                    h[i][j] = curr == 0 ? 0 : h[i][j - 1] + curr;
                } else if (j == 0) {
                    v[i][j] = curr == 0 ? 0 : v[i - 1][j] + curr;
                    h[i][j] = curr;
                } else {
                    v[i][j] = curr == 0 ? 0 : v[i - 1][j] + curr;
                    h[i][j] = curr == 0 ? 0 : h[i][j - 1] + curr;
                }

                ans = Math.max(ans, v[i][j] * h[i][j]);
            }
        }

        return ans;
    }

    private int toInt(char c) {
        return c == '1' ? 1 : 0;
    }

    public static void main(String[] args) {
        //[['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]
        char[][] chars = new char[4][5];
        chars[0] = new char[]{'1','0','1','0','0'};
        chars[1] = new char[]{'1','0','1','1','1'};
        chars[2] = new char[]{'1','1','1','1','1'};
        chars[3] = new char[]{'1','0','0','1','0'};
        System.out.println(new 最大矩形_85().maximalRectangle(chars));
    }
}
