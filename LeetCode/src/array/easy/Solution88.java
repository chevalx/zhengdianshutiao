package array.easy;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] res = new int[m + n];
        int k = 0;
        while (i <= m - 1 && j <= n - 1) {
            if (nums1[i] < nums2[j]) {
                res[k] = nums2[i++];
            } else {
                res[k] = nums1[j++];
            }
            k++;
        }
        while (i <= m - 1) {
            res[k] = nums1[i++];
            k++;
        }
        while (j <= n - 1) {
            res[k] = nums2[j++];
            k++;
        }
        for (int p = 0; p < nums1.length; p++) {
            nums1[p] = res[p];
        }
    }
}
