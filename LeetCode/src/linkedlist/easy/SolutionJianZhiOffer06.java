package linkedlist.easy;

public class SolutionJianZhiOffer06 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode pre = null;
        ListNode post = head;
        int count = 0;
        while (post != null) {
            ListNode tmp = post.next;
            post.next = pre;
            pre = post;
            post = tmp;
            count++;
        }
        int[] ret = new int[count];
        int index = 0;
        while (pre != null) {
            ret[index++] = pre.val;
            pre = pre.next;
        }
        return ret;
    }
}
