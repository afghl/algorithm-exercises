package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * medium
 */
public class 二叉树展开为链表_114 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
                continue;
            }

            // 将左子树，移到右边
            TreeNode lastOfLeft = root.left;
            while (lastOfLeft.right != null) {
                lastOfLeft = lastOfLeft.right;
            }

            lastOfLeft.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
