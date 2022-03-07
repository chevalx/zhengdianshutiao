package linkedlist.medium;

import linkedlist.base.ListNode;

public class Solution148 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,5,3,4,0};
        ListNode head = new ListNode();
        ListNode p = new ListNode();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                head = new ListNode(nums[i]);
                p = head;
            } else {
                p.next = new ListNode(nums[i]);
                p = p.next;
            }
        }
        new Solution148().sortList2(head);
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        qSortList(head, null);
        return head;
    }

    // 快速排序
    public void qSortList(ListNode low, ListNode high) {
        if (low != high && low.next != high) {
            ListNode mid = partition(low, high);
            qSortList(low, mid);
            qSortList(mid.next, high);
        }
    }

    // [low, high)
    public ListNode partition(ListNode low, ListNode high) {
        int pivot = low.val;
        ListNode loc = low;
        for (ListNode i = low.next;  i != high ; i = i.next) {
            if (i.val < pivot) {
                loc = loc.next;
                int tmp = loc.val;
                loc.val = i.val;
                i.val = tmp;
            }
        }
        low.val = loc.val;
        loc.val = pivot;
        return loc;
    }

    // 冒泡排序
    public ListNode sortList(ListNode head) {
        ListNode p = head;
        int length = 1;
        while (p.next != null) {
            p = p.next;
            length++;
        }
        if (length == 1) {
            return head;
        }


        for (int i = 1; i < length; i++) {
            ListNode left = head;
            ListNode right = head.next;
            for (int j = 0; j < length - i; j++) {
                if (left.val > right.val) {
                    int tmp = left.val;
                    left.val = right.val;
                    right.val = tmp;
                }
                right = right.next;
                left = left.next;
            }
        }
        return head;
    }
}
