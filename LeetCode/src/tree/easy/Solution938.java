package tree.easy;

public class Solution938 {
    private int sum;
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    public void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        dfs(root.left, low, high);
        dfs(root.right, low, high);
    }
}
