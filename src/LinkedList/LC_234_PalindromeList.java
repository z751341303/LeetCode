package LinkedList;

/*
234.回文链表
https://leetcode-cn.com/problems/palindrome-linked-list/
 */

// 时间复杂度O(n) 空间复杂度O(1) 先找到中间结点，再将后半部分反转，然后依次比较
public class LC_234_PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newhead = reverse(slow.next);
        while (newhead != null) {
            if (head.val != newhead.val) {
                return false;
            }
            head = head.next;
            newhead = newhead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
