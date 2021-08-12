package tree.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution653 {
    public class TreeNode {
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

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> candidates = new ArrayList<>();
        return dfs(root, candidates, k);
    }

    public boolean dfs(TreeNode root, List<Integer> candidates, int k) {
        if (root == null) {
            return false;
        }
        if (candidates.contains(root.val)) {
            return true;
        } else {
            candidates.add(k - root.val);
            return dfs(root.left, candidates, k) || dfs(root.right, candidates, k);
        }
    }
}
