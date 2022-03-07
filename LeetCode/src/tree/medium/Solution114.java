package tree.medium;

import tree.easy.basic.TreeNode;

public class Solution114 {
    private TreeNode pre; // 记录前一个访问的节点

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
