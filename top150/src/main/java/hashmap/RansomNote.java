package hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("aa", "baba"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.isEmpty()) return true;
        if (magazine.isEmpty()) return false;

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            freq.put(magazine.charAt(i), freq.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char chr = ransomNote.charAt(i);
            if (!freq.containsKey(chr)) {
                return false;
            } else {
                int cnt = freq.get(chr);
                if (cnt == 0) return false;
                freq.put(chr, cnt-1);
            }
        }

        return true;

    }

}
