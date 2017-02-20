import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeOperation {
    public static void main(String[] args) {
        Tree t = new Tree();
        int[] arr = { 8, 4, 20, 2, 6, 15, 30, 1, 3, 5, 7, 17, 70 };
        for (int i : arr) {
            t.insert(i);
        }
//        t.inorderTraversal();
//        t.revert();
//        t.inorderTraversal();
        t.postorderTraversal();
//        t.levelTraversal();
//        t.preorderTraversal();
    }
}

class Tree{
    private Node root;

    public void add(int e) {
        Node n = new Node();
        n.ele = e;
        if (root == null) {
            root = n;
            return;
        }

        Node sup = root;
        while (true) {
            if (sup.ele > e) {
                if (sup.left == null) {
                    sup.left = n;
                } else {
                    sup = sup.left;
                }
            } else {
                if (sup.right == null) {
                    sup.right = n;
                } else {
                    sup = sup.right;
                }
            }
        }
    }

    public void revert() {
//        doRevert(root);
        Node node;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            node = s.pop();
            Node n = node.left;
            node.left = node.right;
            node.right = n;

            if (node.left != null) s.push(node.left);
            if (node.right != null) s.push(node.right);
        }
    }

    private void doRevert(Node node) {
        if (node == null)
            return;

        Node n = node.left;
        node.left = node.right;
        node.right = n;

        doRevert(node.left);
        doRevert(node.right);
    }

    public void insert(int e) {
        Node n = new Node();
        n.ele = e;
        if (root == null) {
            root = n;
        } else {
            doInsert(root, n);
        }
    }

    private Node doInsert(Node tree, Node node) {
        if (tree == null)
            return node;

        if (tree.ele > node.ele)
            tree.left = doInsert(tree.left, node);
        else
            tree.right = doInsert(tree.right, node);

        return tree;
    }

    public void levelTraversal() {
        Node node = root;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            node = q.poll();
            System.out.print(node + "  ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }

        System.out.println();
    }

    public void preorderTraversal() {
        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            Node node = s.pop();
            System.out.print(node + " ");

            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
        }


        System.out.println();
    }

    public void inorderTraversal() {
        Node node = root;
        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                Node n = stack.pop();
                System.out.print(n + "  ");
                node = n.right;
            }
        }

        System.out.println();
    }

    public void postorderTraversal() {
        Node prev = null;
        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            Node curr = s.peek();

            // when traversing down the tree
            if (prev == null || prev.left == curr || prev.right == curr) {
                // push left and right subtree
                if (curr.left != null)
                    s.push(curr.left);
                // 这种情况是：curr 没有左子树，只有右子树
                else if (curr.right != null)
                    s.push(curr.right);
                // is leaf node
                else {
                    System.out.print(curr + "  ");
                    s.pop();
                }
            }

            // when traversing up the tree from the left
            if (curr.left == prev) {
                if (curr.right != null) {
                    s.push(curr.right);
                } else {
                    System.out.print(curr + "  ");
                    s.pop();
                }
            }

            // when traversing up the tree from the right
            if (curr.right == prev) {
                System.out.print(curr + "  ");
                s.pop();
            }

            prev = curr;
        }

        System.out.println();
    }

    class Node {
        Integer ele;
        Node left;
        Node right;

        public String toString() {
            return ele.toString();
        }
    }
}
