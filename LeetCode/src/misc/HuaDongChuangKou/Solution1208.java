package misc.HuaDongChuangKou;

public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int curCost = 0;
        int maxLength = 0;
        int left = 0, right = 0;
        while (right < n) {
            curCost += cost[right];
            right++;
            if (curCost > maxCost) {
                curCost -= cost[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
