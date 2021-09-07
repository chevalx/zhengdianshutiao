package tree.easy;

import tree.easy.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionJianZhiOfferII056 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> elems = new ArrayList<>();
        dfs(root, elems);
        for (int i = 0; i < elems.size(); i++) {
            int second = k - elems.get(i);
            if (elems.contains(second) && second != elems.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void dfs(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        dfs(node.left, values);
        values.add(node.val);
        dfs(node.right, values);
    }
}
