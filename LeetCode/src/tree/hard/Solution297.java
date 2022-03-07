package tree.hard;

import tree.easy.basic.BuildTree;
import tree.easy.basic.TreeNode;

import java.util.*;

public class Solution297 {
    public static void main(String[] args) {
        TreeNode build = new BuildTree().build(new Integer[]{1, 2, 3, null, null, 4, 5});
        Codec codec = new Codec();
        String serialize = codec.serialize(build);
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize.val);
    }


}

/*
如果只要求从一种遍历序列恢复，则遍历的时候需要加上null节点
 */
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(split));
        return buildTree(dataList);
    }

    private TreeNode buildTree(List<String> dataList) {
        if (dataList.get(0).equals("X")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = buildTree(dataList);
        root.right = buildTree(dataList);

        return root;
    }
}