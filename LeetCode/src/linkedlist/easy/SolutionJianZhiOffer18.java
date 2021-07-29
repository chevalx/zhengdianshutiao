package linkedlist.easy;

public class SolutionJianZhiOffer18 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode pre = new ListNode(-1);
        ListNode prehead = pre;
        pre.next = head;
        while (curr != null) {
            if (val == curr.val) {
                pre.next = curr.next;
            }
            curr = curr.next;
            pre = pre.next;
        }
        return prehead.next;
    }
}
