package tree.easy;

import javax.swing.*;



// 原理同 501
public class Solution530 {
    int min = Integer.MAX_VALUE, previous=-1;

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 6};
        int min = Integer.MAX_VALUE, previous;
        for (int i = 0; i < test.length; i++) {
            if (i == 0) {
                min = Integer.MAX_VALUE;
                previous = 0;
                continue;
            }
            int cha = test[i] - test[i - 1];
            if (cha < min) {
                min = cha;
            }
        }
        System.out.println(min);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int getMinimumDifference(TreeNode root) {
        traverseInorder(root);
        return min;
    }

    public void traverseInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseInorder(root.left);
        update(root.val);
        traverseInorder(root.right);
    }

    private void update(int val) {
        if (previous == -1) {
            min = Integer.MAX_VALUE;
            previous = val;
            return;
        }
        int cha = val - previous;
        if (cha < min) {
            min = cha;
        }
        previous = val;
    }
}
