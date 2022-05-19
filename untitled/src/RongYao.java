import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RongYao {

}

class Main2 {
    public static final int EX1 = 3;
    public static final int EX2 = 2;
    public static final int GOOD = 1;
    public static final int BAD = 0;
    static class Person implements Comparable {
        String name;
        int total;
        int num;
        int comment;

        public Person(String data, int num) {
            this.num = num;
            String[] s = data.split(":");
            name = s[0];
            String[] steps = s[1].split(" ");
            ArrayList<Integer> higherThan3w = new ArrayList<>();
            boolean c = true;
            int cnt2 = 0;
            int cnt3 = 0;
            int cnt4 = 0;
            int cnt5 = 0;

            for (int i = 0;i < steps.length; i++) {
                int step = Integer.parseInt(steps[i]);
                if (step > 30000) {
                    cnt2++;
                    higherThan3w.add(i);
                } else if (step > 10000) {
                    cnt3++;
                } else if (step > 5000) {
                    cnt4++;
                } else {
                    cnt5++;
                }
                total += step;
            }

            for (int i = 1; i < higherThan3w.size(); i++) {
                if (higherThan3w.get(i) - higherThan3w.get(i - 1) <= 4) {
                    c = false;
                    break;
                } else {
                    c = true;
                }
            }
            if (cnt2 >= 4 && c) {
                comment = EX1;
            } else if (cnt3 > 15) {
                comment = EX2;
            } else if (cnt4 > 15) {
                comment = GOOD;
            } else if (cnt5 > 18) {
                comment = BAD;
            } else {
                comment = BAD;
            }
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder(name+":");
            if (comment == EX1 || comment == EX2) {
                res.append("excellent");
            } else if (comment == GOOD) {
                res.append("good");
            } else if (comment == BAD) {
                res.append("bad");
            }
            res.append(" ").append(total);
            return res.toString();
        }

        @Override
        public int compareTo(Object o) {
            Person p2 = (Person)o;
            if (this.comment != p2.comment) {
                return this.comment - p2.comment;
            } else if (this.total != p2.total) {
                return this.total - p2.total;
            } else {
                return this.num - p2.num;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = 0;
        ArrayList<Person> people = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String row = scanner.nextLine();
            cnt++;
            Person person = new Person(row, cnt);
            people.add(person);
        }
        Collections.sort(people);
        boolean hasEx = false;
        boolean hasGood = false;
        boolean hasBad = false;
        for (Person person : people) {
            if (person.comment== EX1 || person.comment==EX2) {
                hasEx = true;
            } else if (person.comment == GOOD) {
                hasGood = true;
            } else if (person.comment == BAD) {
                hasBad = true;
            }
            System.out.println(person.toString());
        }
        if (!hasEx) {
            System.out.println("excellent is null");
        } else if (!hasGood) {
            System.out.println("good is null");
        } else if (!hasBad) {
            System.out.println("bad is null");
        }
    }
}
