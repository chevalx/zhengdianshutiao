package linkedlist.base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildFromArray(int[] nums) {
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode nextNode = new ListNode();
            p.val = nums[i];
            if (i == nums.length-1) {
                p.next = null;
            } else {
                p.next = nextNode;
                p = nextNode;
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val+" ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildFromArray(new int[]{1, 3, 5, 7, 9});
        printList(head);
    }
}
