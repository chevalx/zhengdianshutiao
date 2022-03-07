package misc.math;

public class Solution461 {
    public static void main(String[] args) {
        System.out.println();
    }

    public int hammingDistance(int x, int y) {
        // 异或后计算位1的个数
        int n = x ^ y;
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
