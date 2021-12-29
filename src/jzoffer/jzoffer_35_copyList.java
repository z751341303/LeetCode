package jzoffer;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class jzoffer_35_copyList {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        // 在每个节点后复制一个节点
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        // 复制random指针
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 拆分节点(要保证原链表无修改)
        Node newHead = head.next, temp = null;
        cur = head;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return newHead;
    }
}
