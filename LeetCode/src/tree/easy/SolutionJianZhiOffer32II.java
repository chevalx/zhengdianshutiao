package tree.easy;

import tree.easy.basic.TreeNode;

import java.util.*;

public class SolutionJianZhiOffer32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root!=null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> nestedList = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                nestedList.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(nestedList);
        }
        return res;
    }
}
