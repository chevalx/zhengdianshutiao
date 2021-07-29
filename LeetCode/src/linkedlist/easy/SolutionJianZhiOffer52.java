package linkedlist.easy;

public class SolutionJianZhiOffer52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
