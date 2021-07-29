package tree.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//二叉搜索树的中序遍历序列是一个非递减的有序序列
public class Solution501 {
    List<Integer> ret = new ArrayList<>();
    int base, count, maxCount;

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int[] findMode(TreeNode root) {
        traverse(root);
        int[] ans = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            ans[i] = ret.get(i);
        }
        return ans;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        update(root.val);
        traverse(root.right);
    }

    public void update(int val) {
        if (val == base) {
            count++;
        } else {
            base = val;
            count = 1;
        }
        if (count == maxCount) {
            ret.add(val);
        }
        if (count > maxCount) {
            maxCount = count;
            ret.clear();
            ret.add(val);
        }
    }
}
