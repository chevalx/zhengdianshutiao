package linkedlist.medium;

/**
 * 双指针分为两类：快慢指针和左右指针
 * 141. 环形链表（简单）
 * 142. 环形链表II（简单）
 * 167. 两数之和 II - 输入有序数组（中等）
 * 344. 反转字符串（简单）
 * 19. 删除链表倒数第 N 个元素（中等）
 * 876. 链表的中间结点
 */
public class Solution142 {
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

    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == slow) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
        } else {
            return null;
        }
        return slow;
    }
}
