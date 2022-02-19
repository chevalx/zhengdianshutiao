package array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4 {
    public static void main(String[] args) {
        new Solution4().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged.add(nums1[i]);
                i++;
            } else {
                merged.add(nums2[j]);
                j++;
            }
        }

        if (i == nums1.length) {
            while (j < nums2.length) {
                merged.add(nums2[j]);
                j++;
            }
        }

        if (j == nums2.length) {
            while (i < nums1.length) {
                merged.add(nums1[i]);
                i++;
            }
        }

        double res = 0;
        if (merged.size() % 2 == 1) {
            res = merged.get((merged.size() - 1) / 2);
        } else {
            int mid = (merged.size()-1) / 2;
            res = (merged.get(mid) + merged.get(mid + 1)) / 2d;
        }
        return res;
    }
}
