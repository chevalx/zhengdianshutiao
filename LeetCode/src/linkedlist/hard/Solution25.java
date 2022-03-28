package linkedlist.hard;

import linkedlist.base.ListNode;

public class Solution25 {
    public static void main(String[] args) {
        ListNode head = ListNode.buildFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode reversed = new Solution25().reverseKGroup(head, 2);
        ListNode.printList(reversed);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            p = p.next; length++;
        }
        int epoch = length / k;
        int cntInSingleEpoch = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = dummy;
        ListNode stop = start;
        for (int i = 1; i <= epoch ; i++) {
            while (cntInSingleEpoch < k) {
                stop = stop.next;
                cntInSingleEpoch++;
            }
            cntInSingleEpoch = 0;

            ListNode pre = start;
            ListNode post = start.next;
            while (pre != stop) {
                ListNode tmp = post.next;
                post.next = pre;
                pre = post;
                post = tmp;
            }
            start = pre;
            stop = post;
        }
        return head;
    }
}
