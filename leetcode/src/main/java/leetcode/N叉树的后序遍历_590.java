package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 * easy
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class N叉树的后序遍历_590 {

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node curr;

        stack.add(root);

        while (!stack.isEmpty()) {
            curr = stack.pop();

            if (curr == null)
                continue;

            result.addFirst(curr.val);

            // 将curr的叶子节点加到栈中
            if (curr.children != null) {
                for (Node child : curr.children) {
                    stack.push(child);
                }
            }
        }
        return result;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        doPostorder(root, result);
        return result;
    }

    private void doPostorder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (node.children != null && node.children.size() > 0) {
            for (Node child : node.children) {
                doPostorder(child, result);
            }
        }

        result.add(node.val);
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
