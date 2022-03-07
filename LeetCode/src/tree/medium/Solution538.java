package tree.medium;

import tree.easy.basic.BuildTree;
import tree.easy.basic.TreeNode;

public class Solution538 {
    private int pre;

    public static void main(String[] args) {
        TreeNode build = new BuildTree().build(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        System.out.println(new Solution538().convertBST(build).val);
    }

    public TreeNode convertBST(TreeNode root) {
        TreeNode p = root;
        inOrderFromRight(p);
        return root;
    }

    private void inOrderFromRight(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderFromRight(root.right);
        root.val +=pre;
        pre = root.val;
        inOrderFromRight(root.left);
    }
}
