package linkedlist.easy;

public class Solution83 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode quick = head.next;
        while (quick != null) {
            if (slow.val == quick.val) {
                ListNode tmp = quick.next;
                slow.next = tmp;
                quick = tmp;
            } else {
                slow = quick;
                quick = quick.next;
            }
        }
        return head;
    }
}



