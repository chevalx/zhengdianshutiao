public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String maxPrefix = "";
        for (String str : strs) {
            StringBuilder buffer = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                buffer.append(str.charAt(i));
                for (int j = 0; j < strs.length; j++) {
                    if (!strs[j].startsWith(buffer.toString())) {
                        break;
                    }
                }
                String curPrefix = buffer.toString();
                if (curPrefix.length() > maxPrefix.length()) {
                    maxPrefix = curPrefix;
                }
            }
        }
        return maxPrefix;
    }
}
