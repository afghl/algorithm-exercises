package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * easy
 */
public class 二叉树的最小深度_111 {

    /**
     * 递归解法
     */
//    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//
//        int leftDepth = minDepth(root.left);
//        int rightDepth = minDepth(root.right);
//
//        if (root.left == null) {
//            return rightDepth + 1;
//        } else if (root.right == null) {
//            return leftDepth + 1;
//        } else {
//            return Math.min(leftDepth, rightDepth) + 1;
//        }
//
//    }

    /**
     * bfs
     */
//    public int minDepth(TreeNode root) {
//        int depth = 1;
//
//        if (root == null)
//            return depth;
//
//        Queue<TreeNode> q = new LinkedList<>();
//
//        q.offer(root);
//
//        while (!q.isEmpty()) {
//            int count = q.size();
//
//            while (count-- > 0) {
//                depth++;
//                TreeNode node = q.poll();
//                if (node.right == null && node.left == null) {
//                    return depth;
//                } else if (node.left != null) {
//                    q.offer(node.left);
//                } else if (node.right != null) {
//                    q.offer(node.right);
//                }
//            }
//        }
//
//        return depth;
//    }

    /**
     * dfs，其实和递归是一样的
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return left == 0 || right == 0 ? right + left + 1 : Math.min(left, right) + 1;
    }
}
