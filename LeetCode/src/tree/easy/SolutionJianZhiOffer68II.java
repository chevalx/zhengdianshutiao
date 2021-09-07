package tree.easy;

import tree.easy.basic.TreeNode;

public class SolutionJianZhiOffer68II {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if ((left && right) || (root.val == p.val || root.val == q.val) && (left || right)) {
            ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }
}
