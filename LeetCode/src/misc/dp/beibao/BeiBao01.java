package misc.dp.beibao;

import java.util.Scanner;

public class BeiBao01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int V = scanner.nextInt();
        int[] volumes = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            volumes[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        int[] dp = new int[V + 1];
        for (int i = 0; i < V; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = V; j >= volumes[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - volumes[i - 1]] + values[i - 1]);
            }
        }
        System.out.println(dp[V]);
        int[] dp2 = new int[V + 1];
        for (int i = 0; i < V; i++) {
            dp2[i] = Integer.MIN_VALUE;
        }
        dp2[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = V; j >= volumes[i - 1]; j--) {
                dp2[j] = Math.max(dp2[j], dp2[j - volumes[i - 1]] + values[i - 1]);
            }
        }
        if (dp2[V] < 0) {
            dp2[V] = 0;
        }
        System.out.println(dp2[V]);
    }
}
