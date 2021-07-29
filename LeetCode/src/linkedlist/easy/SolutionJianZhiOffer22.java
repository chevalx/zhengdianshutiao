package linkedlist.easy;

public class SolutionJianZhiOffer22 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode post = head;
        for (int i = 0; i < k; i++) {
            if (post == null) {
                return null;
            }
            post = post.next;
        }
        ListNode pre = head;
        while (post != null) {
            pre = pre.next;
            post = post.next;
        }
        return pre;
    }
}
