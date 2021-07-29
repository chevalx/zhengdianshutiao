import java.util.HashMap;

import static javax.swing.text.html.HTML.Tag.I;

// 罗马数字转整数
public class Solution13 {
    public static void main(String[] args) {
        System.out.println(new Solution13().romanToInt("MCMXCIV"));
//        System.out.println(new Solution13().romanToInt("IV"));
    }

    public int romanToInt(String s) {
        int ret = 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if (chars.length == 1) {
            return map.get(chars[0]);
        }

        int slow = 0;
        int quick = 1;

        while (slow < chars.length) {
            Integer cur = map.get(chars[slow]);
            if (slow + 1 < chars.length && cur < map.get(chars[slow + 1])) {
                ret += -cur;
            } else {
                ret += cur;
            }
            slow++;
        }

        return ret;
    }


}
