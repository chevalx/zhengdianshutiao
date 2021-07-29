package tree.easy.basic;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 根据数组建立二叉树
public class BuildTree {
    public static void main(String[] args) {
        Integer[] data = new Integer[]{
                1, 2, 2, null, 3, null, 3
        };
        BuildTree builder = new BuildTree();
        TreeNode root = builder.build(data);
        builder.preorder(root);
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(" " + root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public TreeNode build(Integer[] data) {
        TreeNode root = new TreeNode(data[0]);
        int index = 0;
        int length = data.length;
        TreeNode currNode = null;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (index < length) {
            index++;
            if (index >= length) {
                return root;
            }
            currNode = queue.poll();
            if (data[index] != null) {
                currNode.left = new TreeNode(data[index]);
                queue.offer(currNode.left);
            }
            index++;
            if (index >= length) {
                return root;
            }
            if (data[index] != null) {
                currNode.right = new TreeNode(data[index]);
                queue.offer(currNode.right);
            }
        }
        return root;
    }
}
