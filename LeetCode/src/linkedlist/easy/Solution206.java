package linkedlist.easy;

public class Solution206 {
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

    // 解法1，循环
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode i = head;
        ListNode j = head.next;
        ListNode prehead = new ListNode();
        prehead.next = head;
        ListNode pre = prehead;
        while (j != null) {
            if (pre != prehead) {
                i.next = pre;
            } else {
                i.next = null;
            }
            pre = i;
            i = j;
            j = j.next;
        }
        i.next = pre;
        return i;
    }

    // 解法2，递归
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prehead = new ListNode();
        prehead.next = head;
        ListNode ret = recursive(prehead, head);
        head.next = null;
        return ret;
    }

    public ListNode recursive(ListNode pre, ListNode node) {
        if (node == null) {
            return pre;
        }
        ListNode tmp = node.next;
        node.next = pre;
        return recursive(node, tmp);
    }
}
