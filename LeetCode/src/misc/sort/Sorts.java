package misc.sort;

public class Sorts {
    public static int[] aux;

    public static void main(String[] args) {
        int[] nums = {6,4,8,3,2,98,5,3};
        new Sorts().quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.printf("%d ", num);
        }
        int[] nums2 = {6,4,8,3,2,98,5,3};
        guiBing(nums);
        for (int num : nums) {
            System.out.printf("%d ", num);
        }
    }

    public static void guiBing(int[] nums) {
        int N = nums.length;
        aux = new int[N];
        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N-sz;lo+=sz+sz) {
                merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    public static void merge(int[] nums, int lo, int mid, int hi) {
        // 存到辅助数组里
        for (int i = lo; i <= hi; i++) {
            aux[i] = nums[i];
        }
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }

    /**
     * 快排的应用，见{@link array.medium.Solution215}
     */
    public void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(nums, lo, hi);
        quickSort(nums, lo, j - 1);
        quickSort(nums, j + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] < pivot) {
                if (i >= hi) break;
            }
            while (nums[--j] > pivot) {
                if (j <= lo) break;
            }
            if (i >= j) break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int tmp = nums[j];
        nums[j] = nums[lo];
        nums[lo] = tmp;
        return j;
    }


}
