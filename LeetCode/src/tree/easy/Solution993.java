package tree.easy;


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

    private int xValue = 0;
    private TreeNode xParent = null;
    private int xDepth = 0;
    private boolean xFound = false;

    private int yValue = 0;
    private TreeNode yParent = null;
    private int yDepth = 0;
    private boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.xValue = x;
        this.yValue = y;
        dfs(root, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    public void dfs(TreeNode root, int depth, TreeNode parent) {
        if (root == null) {
            return;
        }

        if (root.val == xValue) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        }
        if (root.val == yValue) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }
        if (xFound & yFound) {
            return;
        }
        dfs(root.left, depth + 1, root);
        if (xFound & yFound) {
            return;
        }
        dfs(root.right, depth + 1, root);
    }
}
