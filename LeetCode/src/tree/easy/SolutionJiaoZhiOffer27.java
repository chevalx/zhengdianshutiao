package tree.easy;

import tree.easy.basic.TreeNode;

public class SolutionJiaoZhiOffer27 {
    public TreeNode mirrorTree(TreeNode root) {
        switchTree(root);
        return root;
    }

    public void switchTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode tmp = left;
        root.left = right;
        root.right = tmp;
        switchTree(root.left);
        switchTree(root.right);
    }
}
