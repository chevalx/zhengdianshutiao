package linkedlist.easy;

public class Solution21 {
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


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode newList = new ListNode();
        ListNode head = newList;
        while (p1 != null && p2!=null) {
            if (p1.val <= p2.val) {
                newList.next = p1;
                newList = p1;
                p1 = p1.next;
            } else {
                newList.next = p2;
                newList = p2;
                p2 = p2.next;
            }
        }
        if (p1 != null) {
            newList.next = p1;
        } else {
            newList.next = p2;
        }
        return head;
    }
}


