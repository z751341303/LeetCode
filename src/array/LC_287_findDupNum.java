package array;

import LinkedList.ListNode;

public class LC_287_findDupNum {
    // 仿照链表寻找环的入口
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        // 因为初始定义slow==fast，所以不能用while(fast != slow)循环
        do{
            fast = nums[nums[fast]];   // fast = fast.next.next
            slow = nums[slow];  // slow = slow.next
        }while(fast != slow);
        fast = 0;
        while(fast != slow) {
            fast = nums[fast];  // fast = fast.next
            slow = nums[slow];  // slow = slow.next
        }
        return fast;
    }

    // 链表寻找环入口
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }
        if(!flag) return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
