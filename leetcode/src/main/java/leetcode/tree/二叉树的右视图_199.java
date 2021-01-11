package leetcode.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * medium
 *
 */
public class 二叉树的右视图_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // bfs

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            // 把全部拿出来
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }

        return result;
    }
}
