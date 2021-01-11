package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 *
 * easy
 */
public class 二叉树的所有路径_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        dfs(root, result, "");

        return result;
    }

    private void dfs(TreeNode node, List<String> result, String path) {
        if (node == null) {
            return;
        }

        path = path + node.val;

        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            path = path + "->";
            dfs(node.left, result, path);
            dfs(node.right, result, path);
        }
    }
}
