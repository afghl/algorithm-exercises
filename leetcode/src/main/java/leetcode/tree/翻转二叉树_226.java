package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * easy
 */
public class 翻转二叉树_226 {

    /**
     * 226. 翻转二叉树
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * 备注:
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode rightNode = null;
        TreeNode leftNode = null;
        if (root.left != null) {
            rightNode = invertTree(root.left);
        }
        if (root.right != null) {
            leftNode = invertTree(root.right);
        }

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }
}
