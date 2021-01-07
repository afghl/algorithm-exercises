package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * <p>
 * easy
 */
public class 平衡二叉树_offer_55 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        // 当前结点为平衡
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}
