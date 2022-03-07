package misc.math;

public class SolutionZJOfferZXTJ003 {
    public static void main(String[] args) {
        System.out.println(new SolutionZJOfferZXTJ003().countOnes(5));
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = countOnes(n);
            res[i] = count;
        }
        return res;
    }

    public int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            num = (num & (num - 1));
            count++;
        }
        return count;
    }
}
