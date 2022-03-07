package tree.medium;

import tree.easy.basic.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            List<Integer> levelValue = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.pollFirst();
                level.add(cur);
            }
            for (TreeNode treeNode : level) {
                levelValue.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            res.add(levelValue);
        }

        return res;
    }
}
