package tree.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution897 {
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

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> elems = new ArrayList<>();
        dfs(root, elems);
        TreeNode head = new TreeNode(-1);
        TreeNode ptr = head;
        for (Integer elem : elems) {
            TreeNode node = new TreeNode(elem);
            ptr.right = node;
            ptr = node;
        }
        return head.right;
    }

    public void dfs(TreeNode root, List<Integer> elems) {
        if (root == null) {
            return;
        }
        dfs(root.left, elems);
        elems.add(root.val);
        dfs(root.right, elems);
    }
}
