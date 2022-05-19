package misc.HuaDongChuangKou;

public class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0, right = 0;
        int n = answerKey.length();
        char[] keys = answerKey.toCharArray();
        int tCount = 0, fCount = 0;
        int maxLength = 0;
        while (right < n) {
            if (keys[right] == 'T') tCount++;
            else fCount++;
            right++;
            if (tCount>k&&fCount>k) {
                if (keys[left] == 'T') tCount--;
                else fCount--;
                left++;
            }
            maxLength = Math.max(maxLength, right-left);
        }
        return maxLength;
    }
}
