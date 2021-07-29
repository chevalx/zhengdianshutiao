package linkedlist.easy;

public class Solution203 {
    static class ListNode {
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

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode();
        ListNode prehead = pre;
        pre.next = head;
        ListNode cursor = head;
        while (cursor != null) {
            if (val == cursor.val) {
                cursor = cursor.next;
                pre.next = cursor;
            } else {
                cursor = cursor.next;
                pre = pre.next;
            }
        }
        return prehead.next;
    }
}
