package tree.easy;

import tree.easy.basic.TreeNode;

public class SolutionJianZhiOffer68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if ((root.val - p.val) * (root.val - q.val) < 0) {
            return root;
        } else if (root.val < p.val){
            return dfs(root.right, p, q);
        } else {
            return dfs(root.left, p, q);
        }
    }
}
