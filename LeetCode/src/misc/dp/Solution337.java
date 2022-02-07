package misc.dp;

import tree.easy.basic.TreeNode;

import java.util.*;

public class Solution337 {
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int do_it = root.val +
                ((root.left == null) ? 0 : rob(root.left.left) + rob(root.left.right)) +
                ((root.right == null) ? 0 : rob(root.right.right) + rob(root.right.left));
        int not_do_it = rob(root.left) + rob(root.right);
        int res = Math.max(do_it, not_do_it);
        memo.put(root, res);
        return res;
    }


    // 错误
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] curCouldSteal = new int[nums.length];
        curCouldSteal[0] = nums[0];
        curCouldSteal[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            int i1 = nums[i] + curCouldSteal[i - 2];
            if (i1 < curCouldSteal[i - 1]) {
                curCouldSteal[i] = curCouldSteal[i - 1];
            } else {
                curCouldSteal[i] = nums[i] + curCouldSteal[i - 2];
            }
        }
        return curCouldSteal[curCouldSteal.length - 1];
    }

    private ArrayList<Integer> CengXuBianLi(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int sum = 0;
            int curLevelSize = queue.size();
            while (curLevelSize-- > 0) {
                TreeNode curRoot = queue.pollFirst();
                sum += curRoot.val;
                if (curRoot.left != null) {
                    queue.addLast(curRoot.left);
                }
                if (curRoot.right != null) {
                    queue.addLast(curRoot.right);
                }
            }
            res.add(sum);
        }
        return res;
    }
}
