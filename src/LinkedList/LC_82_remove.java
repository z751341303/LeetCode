package LinkedList;

/*
82. 删除排序链表中的重复元素 II
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */

public class LC_82_remove {
    // 迭代
    public ListNode deleteDuplicatesA(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head, post;
        while (cur != null && cur.next != null) {
            post = cur.next;
            if (post.val == cur.val) {
                while (post != null && post.val == cur.val) {
                    post = post.next;
                }
                prev.next = post;
                cur = post;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    // 递归
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode post = head.next;
        if (head.val == post.val) {
            while (post != null && post.val == head.val) {
                post = post.next;
            }
            head = deleteDuplicates(post);
        } else {
            head.next = deleteDuplicates(post);
        }
        return head;
    }
}
