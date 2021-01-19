package leetcode.tree;

import leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * easy
 */
public class 二叉树的层序遍历_II_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> s = new Stack<>();
        s.add(root);

        while (!s.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int size = s.size();
            while (size-- > 0) {
                TreeNode node = s.pop();
                level.add(node.val);
                if (node.left != null) s.add(node.left);
                if (node.right != null) s.add(node.right);
            }

            result.addFirst(level);
        }
        return result;
    }

    public static void main(String[] args) {
        int i = 1;
        while (i-- > 0) {
            System.out.println("hello");
        }
    }
}
