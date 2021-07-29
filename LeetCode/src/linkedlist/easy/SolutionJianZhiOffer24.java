package linkedlist.easy;

public class SolutionJianZhiOffer24 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode post = head;
        while (post != null) {
            ListNode tmp = post.next;
            post.next = pre;
            pre = post;
            post = tmp;
        }
        return pre;
    }
}
