package tree.easy;

import java.util.*;

public class Solution637 {

    public class TreeNode {
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

    public List<Double> averageOfLevelsDepth(TreeNode root) {
        List<Integer> count = new ArrayList<>(1);
        List<Double> sum = new ArrayList<>(1);
        List<Double> ans = new ArrayList<>();
        dfs(root, 0, sum, count);
        for (int i = 0; i < count.size(); i++) {
            double currLevelAvg = sum.get(i) / count.get(i);
            ans.add(currLevelAvg);
        }
        return ans;
    }

    public void dfs(TreeNode root, int level, List<Double> sum, List<Integer> count) {
        if (root == null) {
            return;
        }
        if (level >= count.size()) {
            count.add(1);
            sum.add(1.0 * root.val);
        } else {
            count.set(level, count.get(level) + 1);
            sum.set(level, sum.get(level) + 1.0 * root.val);
        }
        dfs(root.left, level + 1, sum, count);
        dfs(root.right, level + 1, sum, count);
    }


    public List<Double> averageOfLevelsWidth(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode queueFirst = queue.peek();
            queue.pop();
            if (queueFirst.left != null) {
                queue.push(queueFirst.left);
            }
            if (queueFirst.right != null) {
                queue.push(queueFirst.right);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(2);
        list.set(0, 1);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
