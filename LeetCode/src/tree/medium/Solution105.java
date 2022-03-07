package tree.medium;

import tree.easy.basic.BuildTree;
import tree.easy.basic.TreeNode;

import java.util.HashMap;

public class Solution105 {
    private HashMap<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildSubTree(0, preorder.length - 1, 0, preorder.length - 1, preorder, inorder);
    }

    private TreeNode buildSubTree(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode curRoot = new TreeNode(preorder[preStart]);
        // find pivot
        int pivot = indexMap.get(preorder[preStart]);
        curRoot.left = buildSubTree(/*preStart*/preStart + 1, preStart + pivot - inStart,
                inStart, pivot - 1, preorder, inorder);
        curRoot.right = buildSubTree(preStart + pivot - inStart + 1, preEnd,
                pivot + 1, inEnd, preorder, inorder);
        return curRoot;
    }
}
