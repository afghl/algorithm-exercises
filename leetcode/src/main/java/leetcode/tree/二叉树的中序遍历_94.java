package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * easy
 */
public class 二叉树的中序遍历_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        doTraversal(root, list);
        return list;
    }

    private void doTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        doTraversal(node.left, list);
        list.add(node.val);

        doTraversal(node.right, list);
    }
}
