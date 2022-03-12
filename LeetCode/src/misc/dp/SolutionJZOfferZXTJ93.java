package misc.dp;

import java.util.HashMap;

public class SolutionJZOfferZXTJ93 {
    public int lenLongestFibSubseq(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        dp[1][0] = 2;
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = arr[i] - arr[j];
                if (map.containsKey(tmp) && map.get(tmp) < j) {
                    dp[i][j] = dp[j][map.get(tmp)]+1;
                } else {
                    dp[i][j] = 2;
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res > 2 ? res : 0;
    }
}
