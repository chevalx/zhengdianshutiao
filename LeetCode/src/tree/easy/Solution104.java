package tree.easy;

public class Solution104 {
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

    public int maxDepth(TreeNode root) {
        return currentDepth(root, 0);
    }

    public int currentDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        } else {
            depth++;
            return Math.max(currentDepth(root.right, depth), currentDepth(root.left, depth));
        }
    }
}
