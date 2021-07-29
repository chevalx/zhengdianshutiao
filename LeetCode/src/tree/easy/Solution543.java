package tree.easy;

public class Solution543 {

    int ans = 1;

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


    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = depth(root.left);
        int R = depth(root.right);
        ans = Math.max(L+R+1, ans);
        return Math.max(L, R) + 1;
    }

}
