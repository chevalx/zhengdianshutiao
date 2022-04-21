package huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int topN = in.nextInt();
        int M = in.nextInt();
        // 注意
//        in.nextLine();
        HashMap<String, Words> map = new HashMap<>();
        ArrayList<Words> list = new ArrayList<>();
        String tmp = in.nextLine();
        for (int i = 0; i < M; i++) {
            String content = in.nextLine();
            String[] s = content.split(" ");
            for (String c : s) {
                if (!map.containsKey(c)) {
                    Words w = new Words(c);
                    w.tvalue++;
                    map.put(c, w);
                    list.add(w);
                } else {
                    Words words = map.get(c);
                    words.tvalue++;
                }
            }

            String content1 = in.nextLine();
            String[] s1 = content1.split(" ");
            for (String c : s1) {
                if (!map.containsKey(c)) {
                    Words w = new Words(c);
                    w.cvalue++;
                    map.put(c, w);
                    list.add(w);
                } else {
                    Words words = map.get(c);
                    words.cvalue++;
                }
            }
        }

        list.sort(new Comparator<Words>() {
            @Override
            public int compare(Words a, Words b) {
                int bs = b.tvalue * 3 + b.cvalue;
                int as = a.tvalue * 3 + a.cvalue;
                if (bs != as) {
                    return bs - as;
                } else if (b.tvalue != a.tvalue) {
                    return b.tvalue - a.tvalue;
                } else {
                    return b.cvalue - a.cvalue;
                }
            }
        });

        for (int i = 0; i < topN; i++) {
            System.out.print(list.get(i).name + " ");
        }
    }
}

class Words {
    String name;
    int tvalue;
    int cvalue;

    public Words(String name) {
        this.name = name;
    }
}
