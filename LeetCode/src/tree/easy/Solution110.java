package tree.easy;

public class Solution110 {
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (Math.abs(getDepth(root.left) - getDepth(root.right)) < 2) {
                return isBalanced(root.left) && isBalanced(root.right);
            } else {
                return false;
            }
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = getDepth(root.left);
            int rightHeight = getDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
