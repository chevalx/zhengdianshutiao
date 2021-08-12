package tree.easy;


import java.util.ArrayList;
import java.util.List;

public class Solution563 {
    class TreeNode {
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

    public int findTilt(TreeNode root) {
        List<Integer> tilts = new ArrayList<>();
        traverse(root, tilts);
        int all = 0;
        for (Integer tilt : tilts) {
            all+=tilt;
        }
        return all;
    }

    public int traverse(TreeNode root, List<Integer> tilts) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left, tilts);
        int right = traverse(root.right, tilts);
        int sum = left + right + root.val;
        int tilt = Math.abs(left - right);
        tilts.add(tilt);
        return sum;
    }
}
