package tree.easy;

public class Solution404 {
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

    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int sum = 0;
        sum = traverse(root, false);
        return sum;
    }

    public int traverse(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        } else {
            return traverse(root.left, true) + traverse(root.right, false);
        }
    }
}
