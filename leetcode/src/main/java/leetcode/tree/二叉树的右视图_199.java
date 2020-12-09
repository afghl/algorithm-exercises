package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        // 不递归，广度优先搜索
        // visit
        List<TreeNode> nodesInLevel = Arrays.asList(root);
        while (!nodesInLevel.isEmpty()) {
            // 这一层的nodes都找到了，最右边那个就是这一层能看到的。
            result.add(nodesInLevel.get(nodesInLevel.size() - 1).val);

            // 找下一层，然后塞到集合里
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : nodesInLevel) {
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }

            nodesInLevel = nextLevel;
        }
        return result;
    }
}
