package tree.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution872 {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Elems = new ArrayList<>();
        List<Integer> root2Elems = new ArrayList<>();
        dfs(root1, root1Elems);
        dfs(root2, root2Elems);
        return root1Elems.equals(root2Elems);
    }

    public void dfs(TreeNode root, List<Integer> elems) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            elems.add(root.val);
        }
        dfs(root.left, elems);
        dfs(root.right, elems);
    }
}
