package tree.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        String singlePath = "";
        findPath(root, ret, singlePath);
        return ret;
    }

    public void findPath(TreeNode root, List<String> paths, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            path += ("->" + root.val);
            path = path.substring(2);
            paths.add(path);
            return;
        } else {
            path += ("->" + root.val);
            findPath(root.left, paths, path);
            findPath(root.right, paths, path);
        }
    }
}
