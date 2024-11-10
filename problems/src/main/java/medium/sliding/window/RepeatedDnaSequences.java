package medium.sliding.window;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDnaSequences {

    public static void main(String[] args) {
        System.out.println(new RepeatedDnaSequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) return new ArrayList<>();

        Set<String> result = new HashSet<>();
        Set<String> seen = new HashSet<>();


        for (int i = 0; i < s.length() - 9; i++) {
            String window = s.substring(i, i + 10);
            if (seen.contains(window)) {
                result.add(window);
            }
            seen.add(window);
        }

        return new ArrayList<>(result);

    }
}
