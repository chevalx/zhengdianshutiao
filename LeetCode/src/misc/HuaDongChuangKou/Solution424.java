package misc.HuaDongChuangKou;

/**
 * follow up
 *
 * 「力扣」第 1004 题：最大连续 1 的个数 III； {@link Solution1004}
 * 「力扣」第 1208 题：尽可能使字符串相等； {@link Solution1208}
 * 「力扣」第 1493 题：删掉一个元素以后全为 1 的最长子数组。 {@link Solution1493}
 */
public class Solution424 {
    public static void main(String[] args) {
        System.out.println(new Solution424().characterReplacement("ABAB", 2));
    }

    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxCount = 0;
        int n = s.length();
        int res = 0;
        int[] freq = new int[26];
        while (right < n) {
            int rightFreq = ++freq[s.charAt(right) - 'A'];
            maxCount = Math.max(maxCount, rightFreq);
            right++;
            if (right - left > maxCount + k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
