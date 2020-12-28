package leetcode.pending;

public class 不同的二叉搜索树_96 {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] results = new int[n];
        results[0] = 1;
        return 1;
    }
}
