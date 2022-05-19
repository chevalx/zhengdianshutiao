package tencent;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) {
        int number = new Solution().getNumber(new int[]{3,1,1,4,5,6});
        System.out.println(number);
    }

    public int getNumber(int[] a) {
        ArrayList<Integer> input = new ArrayList<>();
        for (int i : a) {
            input.add(i);
        }
        while (input.size() != 1) {
            boolean[] isPrime = getPrimes(input.size()+1);
            for (int i = 0; i < input.size(); i++) {
                if (!isPrime[i+1]) {
                    input.set(i, 0);
                }
            }
            input.removeIf(next -> next.equals(0));
        }
        return input.get(0);
    }

    public boolean[] getPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int k = 2; k*i < isPrime.length; k++) {
                    isPrime[i*k] = false;
                }
            }
        }
        return isPrime;
    }
}
