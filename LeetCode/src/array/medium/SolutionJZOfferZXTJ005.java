package array.medium;

public class SolutionJZOfferZXTJ005 {
    public int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (containsSameCharacter(words[i], words[j])) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public boolean containsSameCharacter(String s1, String s2) {
        int[] s1Buffer = new int[128];
        int[] s2Buffer = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            s1Buffer[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            s2Buffer[s2.charAt(i)]++;
        }
        for (int i = 0; i < 128; i++) {
            if (s1Buffer[i] != 0 && s2Buffer[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
