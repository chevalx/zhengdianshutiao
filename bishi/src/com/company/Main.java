package com.company;

public class Main {
    // 字符串，求最长的回文子串
    public static void main(String[] args) {
        String s = "abcvelgoogleul";
        if (s == null || s.length() == 0) {
            System.out.println(0);
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 奇偶
            String r1 = findPalindrome(s, i, i);
            String r2 = findPalindrome(s, i, i + 1);
            String tmp = r1.length() > r2.length() ? r1 : r2;
            res = res.length() > tmp.length() ? res : tmp;
        }
        System.out.println(res);
    }

    private static String findPalindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left+1, right);
    }
}
