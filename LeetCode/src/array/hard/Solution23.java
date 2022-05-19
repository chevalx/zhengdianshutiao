package array.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode listHead : lists) {
            if (listHead != null) {
                queue.add(listHead);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next= node;
            if (node.next != null) {
                queue.add(node);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
