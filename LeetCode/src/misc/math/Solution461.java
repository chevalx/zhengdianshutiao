package misc.math;

public class Solution461 {
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(str.substring(5));
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
