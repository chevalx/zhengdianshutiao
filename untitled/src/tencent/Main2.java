package tencent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer nums = Integer.parseInt(scanner.nextLine().trim());
        ArrayList<Long> res = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            Integer num = Integer.parseInt(scanner.nextLine().trim());
            BigInteger numa = new BigInteger("1"), numb=new BigInteger("1"), numx = new BigInteger("0");
            for (int i = 3; i <= nums ;i++) {
                numx = numa.add(numb);
                numa = numb;
                numb = numx;
            }
            BigInteger r = numb.mod(new BigInteger("1000000007"));
            res.add(r.longValue());
        }
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                System.out.print(res.get(i));
            } else {
                System.out.println(res.get(i));
            }
        }
    }

    public static BigInteger fun(int n) {
        if (n == 1 || n==2){
            return new BigInteger("1");
        }


    }
}

        if (n == 1 || n==2){
                return new BigInteger("1");
                }

                return numb;