package LinkedList;

public class LC_143_reorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;

        // 快慢指针找分割点
        ListNode mid = findMidNode(head);

        // 分割链表，注意要断开
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;

        // 反转第二个链表
        l2 = reverse(l2);

        // 合并
        mergeList(l1, l2);
    }

    ListNode findMidNode(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    void mergeList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode t1 = l1.next;
            ListNode t2 = l2.next;
            l1.next = l2;
            l2.next = t1;
            l1 = t1;
            l2 = t2;
        }
    }
}
