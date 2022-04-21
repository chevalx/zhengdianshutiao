package huawei;

import java.util.Scanner;

public class DanCiZhongLiang {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.next();
        String line = "who love solo";
        String[] words = line.split(" ");
        double allWeight = 0d;
        for (int i = 0;i<words.length;i++) {
            allWeight += (double)words[i].length();
        }
        System.out.printf("%.2f", allWeight/(double)words.length);
    }
}
