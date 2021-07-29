package linkedlist.easy;

public class SolutionMianShiTi0207 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cursorA = headA;
        ListNode cursorB = headB;
        while (cursorA != cursorB) {
            if (cursorA != null) {
                cursorA = cursorA.next;
            } else {
                cursorA = headB;
            }

            if (cursorB != null) {
                cursorB = cursorB.next;
            } else {
                cursorB = headA;
            }
        }
        return cursorA;
    }
}
