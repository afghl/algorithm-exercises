package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * <p>
 * medium
 */
public class 路径总和_II_113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, sum, 0, result, path);

        return result;
    }

    private void dfs(TreeNode node, int sum, int current, List<List<Integer>> result, List<Integer> path) {
        if (node == null) {
            return;
        }

        current += node.val;
        path.add(node.val);

        // 如果是子节点
        if (node.left == null && node.right == null) {
            if (current == sum) {
                result.add(path);
            }
            return;
        }

        // 否则继续遍历
        dfs(node.left, sum, current, result, new ArrayList<>(path));
        dfs(node.right, sum, current, result, new ArrayList<>(path));
    }
}
