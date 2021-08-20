package tree.easy;

public class Solution965 {
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

    public boolean isUnivalTree(TreeNode root) {
        int uni = root.val;
        return dfs(root, uni);
    }

    public boolean dfs(TreeNode root, int uni) {
        if (root == null) {
            return true;
        }
        if (root.val == uni) {
            return dfs(root.left, uni) && dfs(root.right, uni);
        } else {
            return false;
        }
    }
}
