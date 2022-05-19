package com.company;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int[][] dp;
        int[][] round = new int[][]{{1,1,5,5},{6,1,5,1},{3,2,2,2}};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        round = new int[n][4];
        for (int  i = 0; i<n;i++) {
            round[i][0] = scanner.nextInt();
            round[i][1] = scanner.nextInt();
            round[i][2] = scanner.nextInt();
            round[i][3] = scanner.nextInt();
        }
        dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        int res = 0;
        for (int i = 1; i<n;i++) {
            int pickred = dp[i - 1][0] * round[i][0] + dp[i - 1][1] * round[i][1];
            int pickgreen = dp[i - 1][0] * round[i][2] + dp[i - 1][1] * round[i][3];
            if (pickred >= pickgreen) {
                res += Math.max(res, pickred);
                dp[i][0] = dp[i-1][0]++;
                dp[i][1] = dp[i-1][1];
            } else {
                res += Math.max(res, pickgreen);
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1]++;
            }
        }
        System.out.println(res);
    }
}
