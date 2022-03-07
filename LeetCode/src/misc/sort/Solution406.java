package misc.sort;

import java.util.Arrays;
import java.util.Comparator;

public class Solution406 {
    public static void main(String[] args) {
        new Solution406().reconstructQueue(new int[][]{{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}});
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1]-o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < people.length; i++) {
            int actualHigher = 0;
            int shouldHigher = people[i][1];
            for (int j = i-1; j >= 0; j--) {
                if (people[j][0]>=people[i][0]) {
                    actualHigher++;
                }
            }
            if (actualHigher > shouldHigher) {
                people = swim(people, i-(actualHigher-shouldHigher), i);
            }
        }

        return people;
    }

    public int[][] swim(int[][] people, int fromIndex, int shouldSwim) {
        for (int i = shouldSwim; i > fromIndex ; i--) {
//            swap(people, i, i - 1);
            int[] tmp = people[i-1];
            people[i-1] = people[i];
            people[i] = tmp;
        }
        return people;
    }
}
