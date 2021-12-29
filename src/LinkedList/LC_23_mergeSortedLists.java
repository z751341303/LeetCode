package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
23. 合并K个升序链表
https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */

public class LC_23_mergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // 创建最小优先队列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // 把所有的头节点放进去
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        // 每次从队列中取出最小的，并将它的下一个节点加入队列
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
    }
}
