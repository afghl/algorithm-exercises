package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * easy
 */
public class 路径总和_112 {

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return traversal(root, 0, sum);
    }

    private boolean traversal(TreeNode node, int sum, int target) {
        sum = sum + node.val;
        if (node.left == null && node.right == null) {
            return sum == target;
        }

        boolean leftResult = node.left != null && traversal(node.left, sum, target);
        boolean rightResult = node.right != null && traversal(node.right, sum, target);

        return leftResult || rightResult;
    }
}
