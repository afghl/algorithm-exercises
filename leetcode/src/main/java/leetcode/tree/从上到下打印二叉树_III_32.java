package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * <p>
 * medium
 */
public class 从上到下打印二叉树_III_32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<TreeNode>() {{
            add(root);
        }};

        while (!q.isEmpty()) {
            LinkedList<Integer> levelNodes = new LinkedList<>();
            int size = q.size();
            int i = 0;
            // 把这一层的全部拉出来，然后再看
            while (i++ < size) {
                TreeNode node = q.poll();
                if (result.size() % 2 == 0) levelNodes.addLast(node.val); // 偶数层 -> 队列头部
                else levelNodes.addFirst(node.val); // 奇数层 -> 队列尾部
                if (node.right != null) q.add(node.right);
                if (node.left != null) q.add(node.left);
            }

            result.add(levelNodes);
        }

        return result;
    }
}
