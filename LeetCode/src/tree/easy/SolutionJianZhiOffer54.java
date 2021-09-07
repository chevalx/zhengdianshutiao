package tree.easy;

import tree.easy.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionJianZhiOffer54 {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> elems = new ArrayList<>();
        dfs(root, elems);
        return elems.get(elems.size() - k);
    }

    public void dfs(TreeNode root, List<Integer> elems) {
        if (root == null) {
            return;
        }
        dfs(root.left, elems);
        elems.add(root.val);
        dfs(root.right, elems);
    }
}
