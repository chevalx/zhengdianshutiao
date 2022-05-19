package tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine().trim());
        String[] lines = new String[rows];
        for (int i = 0; i < rows; i++) {
            String row = scanner.nextLine().trim();
            lines[i] = row;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < lines[0].length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j< lines.length;j++) {
                sb.append(lines[j].charAt(i));
            }
            res.add(Integer.parseInt(sb.toString()));
        }
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
    }
}
