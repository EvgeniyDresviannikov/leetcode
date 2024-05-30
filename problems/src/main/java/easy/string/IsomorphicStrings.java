package easy.string;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            if (sMap.containsKey(schar) && sMap.get(schar) != tchar) {
                return false;
            } else {
                sMap.put(schar, tchar);
            }

            if (tMap.containsKey(tchar) && tMap.get(tchar) != schar) {
                return false;
            } else {
                tMap.put(tchar, schar);
            }

        }

        return true;
    }
}
