package misc.HuaDongChuangKou;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口系列
 * 76. 最小覆盖子串（困难）
 * 567. 字符串的排列（中等）
 * 438. 找到字符串中所有字母异位词（中等）
 * 3. 无重复字符的最长子串（中等）
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        // window 记录窗口满足t的字符以及它们出现的次数
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);  // 相当于need[c]++
        }

        int left = 0, right = 0; // 左闭右开的窗口
        int valid = 0; // 窗口中满足need条件的字符的个数，例如need={a:1, b:2, c:1}, window={a:1, b:3, c:1} 则valid = 3，
        // window中多出来的字符出现次数不算
        int start = 0, len = Integer.MAX_VALUE; // 记录最小覆盖子串的索引及长度
        while (right < s.length()) { // 当右指针到达s的尽头时终止移动
            // c 即将进入窗口
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 若need里有c
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);  // 应该把c加入到window里
                if (need.get(c).equals(window.get(c))) {  // 若 need中c的个数恰好满足window中c的个数，则valid+1
                    valid++;
                }
            }
            // 若valid一直小于need.size()，则说明未找到可行解，右指针应继续向右移动扩大窗口
            // 若经过扩大窗口，valid等于need.size()，则说明已找到可行解，此时需要收缩窗口
            while (valid == need.size()) {
                // 此时已找到可行解，更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 即将移出窗口
                char d = s.charAt(left);
                // 左指针右移，缩小窗口
                left++;
                if (need.containsKey(d)) { // 若need中有d，则说明我们移出掉了一个满足条件的字符，
                    if (need.get(d).equals(window.get(d))) { // 若移出前，need中d的次数和window中d的次数相等，
                        // 则此时window不再满足need的要求，应把valid-1
                        valid--; // 此时该循环就是最后一轮，
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
