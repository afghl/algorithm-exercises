package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * easy
 */
public class 二叉树的直径_543 {

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     *
     * 示例 :
     * 给定二叉树
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     *
     *  
     *
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     */
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }

        int leftSize = node.left == null ? 0 : dfs(node.left) + 1;
        int rightSize = node.right == null ? 0 : dfs(node.right) + 1;

        max = Math.max(max, leftSize + rightSize);
        return Math.max(leftSize, rightSize) + 1;
    }
}
