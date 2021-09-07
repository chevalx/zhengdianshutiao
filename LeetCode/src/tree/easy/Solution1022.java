package tree.easy;

import tree.easy.basic.BuildTree;
import tree.easy.basic.TreeNode;

public class Solution1022 {
    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, "");
        return sum;
    }

    public void dfs(TreeNode root, String binBuf) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            binBuf += String.valueOf(root.val);
            sum += Integer.parseInt(binBuf, 2);
        } else {
            binBuf += String.valueOf(root.val);
            dfs(root.left, binBuf);
            dfs(root.right, binBuf);
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{
                1, 0, 1, 0, 1, 0, 1
        };
        BuildTree builder = new BuildTree();
        TreeNode root = builder.build(data);
        builder.preorder(root);

        new Solution1022().sumRootToLeaf(root);
    }
}
