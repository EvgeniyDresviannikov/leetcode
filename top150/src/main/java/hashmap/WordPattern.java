package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> visitedWords = new HashSet<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char letter = pattern.charAt(i);
            if (map.containsKey(letter)) {
                if (!map.get(letter).equals(words[i])) {
                    return false;
                }
            } else {
                if (visitedWords.contains(words[i])) return false;

                map.put(letter, words[i]);
                visitedWords.add(words[i]);
            }
        }

        return true;
    }
}
