public class SolutionJZOfferZXTJ18 {
    public static void main(String[] args) {
        boolean isPal = new SolutionJZOfferZXTJ18().isPalindrome("0P");
        System.out.println(isPal);
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
