package tree.medium;

import tree.easy.basic.BuildTree;
import tree.easy.basic.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution113 {
    public static void main(String[] args) {
        TreeNode root = new BuildTree().build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        new Solution113().pathSum(root, 22);
    }

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<TreeNode> path = new LinkedList<>();
        path.add(root);
        backtrack(root, path, targetSum, root.val);
        return res;
    }

    public void backtrack(TreeNode root, LinkedList<TreeNode> path, int target, int sum) {
        if (sum == target && root.left == null && root.right == null) {
            List<Integer> validPath = new LinkedList<>();
            for (TreeNode node : path) {
                validPath.add(node.val);
            }
            res.add(validPath);
            return;
        }
        if (root.left != null) {
            path.add(root.left);
            backtrack(root.left, path, target, sum + root.left.val);
            path.removeLast();
        }
        if (root.right != null) {
            path.add(root.right);
            backtrack(root.right, path, target, sum + root.right.val);
            path.removeLast();
        }
    }
}
