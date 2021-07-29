package linkedlist.easy;

import java.util.LinkedList;


// 回文序列的特性：一是对称，二是整体上从左到右等于从右到左
public class Solution234 {
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

    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode tmp1 = head;
        while (tmp1 != null) {
            stack.push(tmp1.val);
            tmp1 = tmp1.next;
        }

        ListNode tmp2 = head;
        while (tmp2 != null) {
            if (tmp2.val != stack.pop()) {
                return false;
            }
            tmp2 = tmp2.next;
        }

        return true;
    }
}
