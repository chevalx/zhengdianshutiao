package tree.medium;

import tree.easy.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> elems = new ArrayList<>();
        dfs(root, elems);
        if (elems.size() == 1) {
            return true;
        }
        for (int i = 1; i < elems.size(); i++) {
            if (elems.get(i) < elems.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> elems) {
        if (root == null) {
            return;
        }
        dfs(root.left, elems);
        elems.add(root.val);
        dfs(root.right, elems);
    }
}
