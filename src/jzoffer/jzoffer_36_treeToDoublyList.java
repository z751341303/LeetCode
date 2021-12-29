package jzoffer;

class Node36 {
    public int val;
    public Node36 left;
    public Node36 right;

    public Node36() {}

    public Node36(int _val) {
        val = _val;
    }

    public Node36(int _val,Node36 _left,Node36 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class jzoffer_36_treeToDoublyList {
    Node36 cur = new Node36();
    Node36 newHead = cur;
    public Node36 treeToDoublyList(Node36 root) {
        if (root == null) return null;
        inOrder(root);
        newHead.right.left = cur;
        cur.right = newHead.right;
        return newHead.right;
    }
    private void inOrder(Node36 root) {
        if (root == null) return;
        inOrder(root.left);
        cur.right = root;
        root.left = cur;
        cur = root;
        inOrder(root.right);
    }
}
