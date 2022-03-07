package misc.math;

public class Solution338 {
    // 动态规划解法
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        bits[1] = 1;
        int y = 0;
        for (int x = 0; x <= n; x++) {
            if ((x & (x - 1)) == 0) {
                y = x;
            }
            bits[x] = bits[x - y] + 1;
        }
        return bits;
    }

    // 常规kernighan解法
    public int[] countBitsNormal(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int tmp = i;
            int count = 0;
            while (tmp > 0) {
                tmp = (tmp & (tmp - 1));
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}
