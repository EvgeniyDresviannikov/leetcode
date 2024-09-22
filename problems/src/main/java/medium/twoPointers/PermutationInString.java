package medium.twoPointers;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab", "eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> permutationMap = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            permutationMap.put(c, permutationMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int len = s2.length();
        while (left < len - s1.length()) {
            if (permutationMap.containsKey(s2.charAt(left))) {
                int right = left;
                int cnt = 0;
                while (right < len && permutationMap.containsKey(s2.charAt(right)) && permutationMap.get(s2.charAt(right)) > 0) {
                    Character chr = s2.charAt(right);
                    permutationMap.put(chr, permutationMap.get(chr) - 1);
                    cnt++;
                    if (cnt == s1.length()) return true;
                    right++;
                }
                if (cnt > 0) {
                    for (int i = left; i < right; i++) {
                        Character c = s2.charAt(i);
                        permutationMap.put(c, permutationMap.get(c) + 1);
                    }
                    cnt = 0;
                }
            }
            left++;
        }

        return false;
    }
}
