package tree.medium;

import tree.easy.basic.BuildTree;
import tree.easy.basic.TreeNode;

public class Solution437 {
    private int res = 0;

    public static void main(String[] args) {
        TreeNode build = new BuildTree().build(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        new Solution437().pathSum(build, 8);
    }


    public int pathSum(TreeNode root, int targetSum) {
        tmp(root, targetSum);
        return res;
    }

    public void tmp(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        int curSum = root.val;
        inOrder(root, targetSum, 0);
        tmp(root.left, targetSum);
        tmp(root.right, targetSum);
    }

    public void inOrder(TreeNode root, int targetSum, int curSum) {
        if (root == null) {
            return;
        }
        curSum += root.val;
        if (curSum == targetSum) {
            res++;
        }
        inOrder(root.left, targetSum, curSum);
        inOrder(root.right, targetSum, curSum);
    }
}
