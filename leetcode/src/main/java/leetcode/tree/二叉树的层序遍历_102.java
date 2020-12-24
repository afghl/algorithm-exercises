package leetcode.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 * medium
 */
public class 二叉树的层序遍历_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            // 全部拿出来
            List<Integer> result = new ArrayList<>();
            
            int count = q.size();
            while (count-- > 0) {
                TreeNode node = q.poll();
                result.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            results.add(result);
        }

        return results;
    }
}
