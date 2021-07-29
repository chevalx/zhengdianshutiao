public class Solution9 {
    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        int input = x;
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE && pop > 7)) return false;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE && pop < -8)) return false;
            rev = rev * 10 + pop;
        }
        if (rev == input) {
            return true;
        } else {
            return false;
        }
    }
}
