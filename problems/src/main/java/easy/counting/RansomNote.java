package easy.counting;

import java.util.Objects;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("bjaajgea", "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            alphabet[(int) magazine.charAt(i) - (int)'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (alphabet[(int) ransomNote.charAt(i) - (int)'a'] == 0) return false;
            alphabet[(int) ransomNote.charAt(i) - (int)'a']--;
        }

        return true;
    }

}
