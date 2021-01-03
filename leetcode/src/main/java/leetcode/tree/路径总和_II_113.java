package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * medium
 */
public class 路径总和_II_113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        traversal(root, sum, 0, result, path);

        return result;
    }

    private void traversal(TreeNode node, int sum, int current, List<List<Integer>> result, List<Integer> path) {
        current += node.val;
        path.add(node.val);

        // 如果是子节点
        if (node.left == null && node.right == null) {
            if (current == sum) {
                result.add(path);
            }
        }

        // 否则继续遍历
        if (node.left != null) {
            traversal(node.left, sum, current, result, new ArrayList<>(path));
        }
        if (node.right != null) {
            traversal(node.right, sum, current, result, new ArrayList<>(path));
        }
    }
}
