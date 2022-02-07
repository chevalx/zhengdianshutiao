package misc.dp;


import annotations.DP;

/**
 * 动态规划
 * 1. 动态规划的一般形式是求最值
 * 2. 动态规划其实是运筹学的一种最优化方法，只不过在计算机问题上应用比较多，比如说让你求最长递增子序列，最小编辑距离
 * 3. 求解动态规划的核心问题是穷举
 * 4. 暴力穷举效率低下
 * 5.
 */
@DP
public class Solution509 {
    /**
     * 解法一，暴力递归
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 解法二，带备忘录的递归
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        // 备忘录初始化为0
        int[] memo = new int[n + 1];
        return helper2(memo, n);
    }

    public int helper2(int[] memo, int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }
        // 说明helper2(memo, n)已经被计算过
        if (memo[n] != 0) return memo[n];
        memo[n] = helper2(memo, n - 1) + helper2(memo, n - 2);
        return memo[n];
    }

    /**
     * 利用dp数组
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n == 0) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 动态规划，状态压缩
     * @param n
     * @return
     */
    public int fib4(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

}
