package tree.easy;

public class Solution226 {
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        switching(root);
        return root;
    }

    private void switching(TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        } else if (root.left == null || root.right == null) {
            if (root.left == null) {
                root.left = root.right;
                root.right = null;
                switching(root.left);
            } else {
                root.right = root.left;
                root.left = null;
                switching(root.right);
            }
        } else {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            switching(root.left);
            switching(root.right);
        }
    }
}
