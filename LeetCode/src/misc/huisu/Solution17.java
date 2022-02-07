package misc.huisu;

import annotations.HuiSu;

import java.util.*;

@HuiSu
public class Solution17 {
    public static void main(String[] args) {
        String digits = "23";
        new Solution17().letterCombinations(digits);
    }

    private HashMap<Integer, String> boards = new HashMap<>();
    private List<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<>();
        }
        boards.put(2, "abc");
        boards.put(3, "def");
        boards.put(4, "ghi");
        boards.put(5, "jkl");
        boards.put(6, "mno");
        boards.put(7, "pqrs");
        boards.put(8, "tuv");
        boards.put(9, "wxyz");
        char[] chars = digits.toCharArray();
        int[] digitArray = new int[chars.length];
        for (int i = 0; i < digitArray.length; i++) {
            digitArray[i] = Character.digit(chars[i], 10);
        }
        LinkedList<Character> combination = new LinkedList<>();
        backtrack(digitArray, 0, combination);
        return res;
    }

    public void backtrack(int[] digitArray, int index, LinkedList<Character> combination) {
        if (index == digitArray.length) {
            StringBuilder sb = new StringBuilder(combination.size());
            for (Character character : combination) {
                sb.append(character);
            }
            res.add(sb.toString());
            return;
        }
        char[] charsOfDigit = boards.get(digitArray[index]).toCharArray();
        for (int i = 0; i < charsOfDigit.length; i++) {
            combination.add(charsOfDigit[i]);
            backtrack(digitArray, index + 1, combination);
            combination.removeLast();
        }
    }
}
