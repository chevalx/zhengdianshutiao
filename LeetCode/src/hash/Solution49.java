package hash;

import annotations.Hash;
import annotations.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Hash
@Sort
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> integerList = map.getOrDefault(s, new ArrayList<>());
            integerList.add(strs[i]);
            map.put(s, integerList);
        }
        return new ArrayList<>(map.values());
    }
}
