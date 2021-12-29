package LinkedList;

/*
25. K 个一组翻转链表
https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */

public class LC_25_reverseKGroup {
    // 递归
    public ListNode reverseKGroup_A(ListNode head, int k) {
        if (head == null) return head;
        ListNode a, b;
        a = b = head;
        // base case
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup_A(b, k);
        return newHead;
    }

    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, post;
        pre = null;
        cur = a;
        while (cur != b) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }

    // 迭代
    public ListNode reverseKGroup_B(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy, cur = head, post;
        dummy.next = head;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        head = dummy.next;

        // 需要翻转的次数为len/k次
        for (int i = 0; i < len / k; i++) {
            // 每k个节点操作k-1次
            for (int j = 0; j < k - 1; j++) {
                post = cur.next;
                cur.next = post.next;
                post.next = pre.next;
                pre.next = post;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
