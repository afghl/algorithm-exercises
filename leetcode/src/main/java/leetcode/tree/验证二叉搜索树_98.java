package leetcode.tree;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * medium
 */
public class 验证二叉搜索树_98 {

    //
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<Integer> stack = new Stack<>();
        return inorderTraversal(root, stack);
    }

    private boolean inorderTraversal(TreeNode node, Stack<Integer> stack) {
        if (node == null) {
            return true;
        }

        if (!inorderTraversal(node.left, stack)) {
            return false;
        }

        // 处理节点
        if (!stack.isEmpty() && stack.peek() < node.val) {
            return false;
        } else {
            stack.add(node.val);
        }

        return inorderTraversal(node.right, stack);
    }



//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root);
//    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (min != null && val <= min) {
            return false;
        }
        if (max != null && val >= max) {
            return false;
        }

        // 右子树的所有节点都应该大于val
        if (!isValidBST(node.right, val, max)) {
            return false;
        }

        // 左子树的所有节点都应该小于val
        if (!isValidBST(node.left, min, val)) {
            return false;
        }
        return true;
    }





    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        return traversal(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean traversal(TreeNode node, long max, long min) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        if (!traversal(node.left, node.val, min)) {
            return false;
        }

        if (!traversal(node.right, max, node.val)) {
            return false;
        }

        return true;
    }
}
