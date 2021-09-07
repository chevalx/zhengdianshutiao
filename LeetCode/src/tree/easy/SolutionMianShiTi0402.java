package tree.easy;

import tree.easy.basic.TreeNode;

public class SolutionMianShiTi0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    public TreeNode build(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, lo, mid);
        node.right = build(nums, mid + 1, hi);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        new SolutionMianShiTi0402().sortedArrayToBST(nums);
    }
}
