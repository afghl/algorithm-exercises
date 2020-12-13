package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * medium
 */
public class 二叉树的锯齿形层次遍历_103 {

    /**
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层次遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * 就是第一层是从左到右，第二层是从右到左这样
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        int level = 1;

        doBfs(Arrays.asList(root), level, result);

        return result;
    }

    private void doBfs(List<TreeNode> nodes, int level, List<List<Integer>> result) {
        // 将这一层的nodes，加到result里去
        List<Integer> values = new ArrayList<>(nodes.size());
        if (level % 2 == 1) {  // 基数，从左到右
            for (int i = 0; i < nodes.size(); i++) {
                values.add(nodes.get(i).val);
            }
        } else {  // 偶数，从右到左
            for (int i = nodes.size() - 1; i >= 0; i--) {
                values.add(nodes.get(i).val);
            }
        }

        result.add(values);

        // 找下一层的nodes
        List<TreeNode> nextLevel = new ArrayList<>();

        for (TreeNode node : nodes) {
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }

        if (!nextLevel.isEmpty()) {
            doBfs(nextLevel, level + 1, result);
        }
    }
}
