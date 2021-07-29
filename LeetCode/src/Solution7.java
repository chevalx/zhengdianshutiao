import java.util.ArrayList;
import java.util.List;

public class Solution7 {
    public static void main(String[] args) {
        System.out.println(new Solution7().reverse(1534236469));
        System.out.println(Math.pow(2, 31));
    }

    public int answer(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public int reverse(int x) {
        if (x <= -Math.pow(2, 31) || x >= Math.pow(2, 31) - 1) {
            return 0;
        }
        int y = 0;
        boolean negative = false;
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            x = -x;
            negative = true;
        }
        List<Integer> l = new ArrayList<>();
        int shang = 1;
        while (shang > 0) {
            int yu = x % 10;
            shang = (int) Math.floor(x / 10);
            x = shang;
            l.add(yu);
        }
        int index = 0;
        for (int i = l.size() - 1; i >= 0; i--) {
            y = (int) (y + l.get(index) * Math.pow(10, i));
            if (y == 2147483647) {
                return 0;
            }
            index++;
        }
        if (negative) {
            y = -y;
        }
        if (y < -Math.pow(2, 31) || y > Math.pow(2, 31) - 1) {
            return 0;
        }
        return y;
    }
}
