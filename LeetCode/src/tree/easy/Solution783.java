package tree.easy;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * 同Solution530
 */
public class Solution783 {
    public int min = Integer.MAX_VALUE, previous = -1;
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

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int val){
        int cha;
        if (previous == -1) {
            cha = Integer.MAX_VALUE;
        } else {
            cha = Math.abs(val - previous);
        }
        if (cha < min) {
            min = cha;
        }
        previous = val;
    }

}
