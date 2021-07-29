package linkedlist.easy;

public class SolutionMianShiTi0206 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        ListNode pre = null;
        ListNode post = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            ListNode tmp = post.next;
            post.next = pre;
            pre = post;
            post = tmp;
        }

        if (fast != null) {
            post = post.next;
        }

        while (pre != null) {
            if (pre.val != post.val) {
                return false;
            }
            pre = pre.next;
            post = post.next;
        }

        return true;
    }
}
