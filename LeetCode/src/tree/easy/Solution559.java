package tree.easy;

import java.util.List;

public class Solution559 {
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

    public int maxDepth(Node root) {
        return curDepth(root, 0);
    }

    public int curDepth(Node node, int depth) {
        if (node == null) {
            return depth;
        } else {
            depth++;
            int max = 0;
            for (Node child : node.children) {
                int curDepth = curDepth(child, depth);
                if (curDepth > max) {
                    max = curDepth;
                }
            }
            return max + 1;
        }
    }
}
