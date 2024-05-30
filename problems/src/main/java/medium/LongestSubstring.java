package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();

        String str = "aab";
        var res = longestSubstring.lengthOfLongestSubstring(str);

        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<String, Integer> uniqueChars = new HashMap<>();
        int maxLength = 0;

        String[] symbols = s.split("");
        for (int i = 0; i < symbols.length; i++) {
            String curr = symbols[i];
            if (uniqueChars.containsKey(curr)) {
                maxLength = Math.max(uniqueChars.size(), maxLength);
                i = uniqueChars.get(curr);
                uniqueChars.clear();
            } else {
                uniqueChars.put(curr, i);
            }
        }
        maxLength = Math.max(uniqueChars.size(), maxLength);

        return maxLength;
    }
}
