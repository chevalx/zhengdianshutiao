package tree.easy;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

public class Solution993 {
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

    public boolean isCousins(TreeNode root, int x, int y) {
        if (dfs(root, x, 0) == dfs(root, y, 0)) {
            return isCommonParent(root, x, y);
        }
        return false;
    }

    public int dfs(TreeNode root, int elem, int depth) {
        if (root == null) {
            return 0;
        }
        if (root.val == elem) {
            return depth;
        } else {
            return Math.max(dfs(root.left, elem, ++depth), dfs(root.right, elem, ++depth));
        }
    }

    public boolean isCommonParent(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null) {
            if ((root.left.val == x || root.right.val == y) || (root.left.val == y) || (root.right.val == x)) {
                return true;
            } else {
                return false;
            }
        }
        return isCommonParent(root.left, x, y) && isCommonParent(root.right, x, y);
    }
}
