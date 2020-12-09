package leetcode.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * easy
 */
public class 二叉树的最大深度_104 {

    public int maxDepth(TreeNode root) {
        return doVisit(root, 0);
    }


    private int doVisit(TreeNode node, int currentDepth) {
        if (node == null) {
            return 0;
        }

        int rightDepth = doVisit(node.right, currentDepth + 1);
        int leftDepth = doVisit(node.left, currentDepth + 1);
        return Math.max(rightDepth, leftDepth);
    }
}
