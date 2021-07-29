package tree.easy;

import java.util.LinkedList;

public class Solution112 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return test(root, targetSum, 0);
    }

    public boolean test(TreeNode root, int targetSum, int currentSum) {
        if (root.left == null && root.right == null) {
            return targetSum == currentSum + root.val;
        } else if (root.left == null || root.right == null) {
            return test(root.left == null ? root.right : root.left, targetSum, currentSum + root.val);
        } else {
            return test(root.left, targetSum, currentSum + root.val) || test(root.right, targetSum, currentSum + root.val);
        }
    }
}
