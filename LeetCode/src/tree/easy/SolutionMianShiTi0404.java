package tree.easy;

import tree.easy.basic.BuildTree;
import tree.easy.basic.TreeNode;

public class SolutionMianShiTi0404 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
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
