import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> res = new ArrayList<>();
        int n = scanner.nextInt();// 城市个数
        int  m = scanner.nextInt();  // 朋友个数
        int x = scanner.nextInt();  // 体力
        int[] cities = new int[n];
        int[] friends = new int[m];
        for (int i =0;i<n;i++) {
            cities[i] = scanner.nextInt();
        }
        for (int i  = 0;i<m;i++) {
            friends[i] = scanner.nextInt();
        }
        boolean[] xiao7 = new boolean[n];  // 小7能到达的城市
        xiao7[0] = true;
        for (int i =1;i<n;i++) {
            if (cities[i] - cities[i-1]<=x)  xiao7[i]=true;
            else xiao7[i]=false;
        }
        for (int i = 0;i<m;i++) {
            boolean[] singleFriend = new boolean[n];
            singleFriend[0] = true;
            for (int j =1;j<n;j++) {
                if (cities[j] - cities[j-1]<=friends[i])  {
                    // 朋友可以爬
                    singleFriend[j]=true;
                }
                else singleFriend[j]=false;
            }
            if (Arrays.equals(singleFriend, xiao7))
                res.add(i+1);
        }
        for (int i = 0; i< res.size(); i++) {
            System.out.printf("%d ", res.get(i));
        }
    }
    private static String findPalindrome(String s, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i)!=s.charAt(j)) {
                break;
            }
            i--;j++;
        }
        return s.substring(i+1,j);
    }
}
