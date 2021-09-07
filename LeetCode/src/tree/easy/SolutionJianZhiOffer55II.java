package tree.easy;

import tree.easy.basic.TreeNode;

public class SolutionJianZhiOffer55II {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) < 2) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
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
