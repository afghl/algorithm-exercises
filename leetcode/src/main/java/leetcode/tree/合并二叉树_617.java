package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * easy
 *
 */
public class 合并二叉树_617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        int val;

        if (t1 == null) {
            val = t2.val;
        } else if (t2 == null) {
            val = t1.val;
        } else {
            val = t1.val + t2.val;
        }
        TreeNode node = new TreeNode(val);
        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return node;
    }
}
