package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 * easy
 *
 */
public class N叉树的前序遍历_589 {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        traversal(root, result);
        return result;
    }

    private void traversal(Node node, List<Integer> l) {
        if (node == null) {
            return;
        }

        l.add(node.val);
        for (Node child : node.children) {
            traversal(child, l);
        }
    }

    /**
     * 递归
     */
//    public List<Integer> preorder(Node root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//
//
//
//        preOrderTraversal(root, result);
//        return result;
//    }

    private void preOrderTraversal(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);

        for (Node child : node.children) {
            preOrderTraversal(child, result);
        }
    }
}
