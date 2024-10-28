package medium.backtracking;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {

    public static void main(String[] args) {
        System.out.println(new StringPermutations().getPermutations("abac"));
    }

    Set<String> result = new HashSet<>();
    int size;

    public Set<String> getPermutations(String str) {
        this.size = str.length();

        dfs(new StringBuilder(), new StringBuilder(str));

        return result;
    }

    private void dfs(StringBuilder sb, StringBuilder rest) {
        if (sb.length() == size) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < rest.length(); i++) {
            char c = rest.charAt(i);
            sb.append(c);
            rest.deleteCharAt(i);
            dfs(sb, rest);
            sb.deleteCharAt(sb.length()-1);
            rest.insert(i, c);
        }
    }
}
