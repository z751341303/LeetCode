package LinkedList;

public class LC_92_recerse {
    /*
    1 翻转整个链表
     */
    // 迭代
    public ListNode reverseListA(ListNode head) {
        ListNode prev, cur, post;
        prev = null;
        cur = head;
        post = null;
        while (cur != null) {
            post = cur.next;
            cur.next = prev;
            prev = cur;
            cur = post;
        }
        return prev;
    }

    // 递归
    public ListNode reverseListB(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode last = reverseListB(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /*
    2 翻转链表前n个结点
     */

    ListNode successor = null; // 后驱节点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    /*
    3 翻转链表的m到n结点
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 创建虚拟头节点，方便找到前驱节点superior
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode superior = dummyHead;
        ListNode prev, cur, post;

        // 遍历至left的前一个节点
        for (int i = 0; i < left - 1; i++) {
            superior = superior.next;
        }
        prev = null;
        cur = superior.next;
        post = null;
        for (int i = 0; i <= right - left ; i++) {
            post = cur.next;
            cur.next = prev;
            prev = cur;
            cur = post;
        }

        superior.next.next = cur;
        superior.next = prev;
        return dummyHead.next;
    }

}
