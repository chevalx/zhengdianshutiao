package misc.dp;

/**
 * 问题问的是找到最好的扔鸡蛋的策略，最好的意思是扔鸡蛋的次数最少
 */
public class Solution887 {

    public static void main(String[] args) {
        System.out.println(new Solution887().superEggDrop(2, 6));
    }

    // 全局变量，记录递归函数的递归层数
    int count = 0;

    // 输入 n，打印 n 个 tab 缩进
    void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("   ");
        }
    }

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    public int dp(int k, int n) {
        printIndent(count++);
        System.out.printf("k = %d, n = %d\n", k, n);
        if (k == 1) {
            printIndent(--count);
            System.out.printf("return %d\n", n);
            return n;
        }
        if (n == 0){
            printIndent(--count);
            System.out.printf("return %d\n", 0);
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res,
                    Math.max(dp(k - 1, i - 1), dp(k, n - i) + 1)
            );
        }
        printIndent(--count);
        System.out.printf("return %d\n", res);
        return res;
    }
}
