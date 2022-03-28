package tree.medium;

import tree.easy.basic.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> levelBuffer = new ArrayList<>();
            List<Integer> valueBuffer = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.pollFirst();
                levelBuffer.add(node);
                valueBuffer.add(node.val);
            }
            for (TreeNode children : levelBuffer) {
                TreeNode left = children.left;
                TreeNode right = children.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            res.add(valueBuffer);
        }
        return res;
    }
}
