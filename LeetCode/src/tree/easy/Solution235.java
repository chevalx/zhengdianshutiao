package tree.easy;

public class Solution235 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val-p.val) * (root.val-q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }
}
