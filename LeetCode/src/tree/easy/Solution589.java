package tree.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    public void dfs(Node node, List<Integer> elems) {
        if (node == null) {
            return;
        }
        elems.add(node.val);
        for (Node child : node.children) {
            dfs(child, elems);
        }
        return;
    }
}
