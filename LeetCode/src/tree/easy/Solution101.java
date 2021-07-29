package tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution101 {
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

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    // 递归
    public boolean check(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    // 迭代
    public boolean check2(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            TreeNode pre = queue.poll();
            TreeNode post = queue.poll();
            if (pre == null && post == null) {
                continue;
            }
            if ((pre == null || post == null) || pre.val != post.val) {
                return false;
            }
            queue.offer(pre.left);
            queue.offer(post.right);

            queue.offer(pre.right);
            queue.offer(post.left);
        }
        return true;
    }
}
