package medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private List<String> result = new ArrayList<>();
    private int N;

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        N = n;

        backtrack("", 0, 0);

        return result;
    }

    private void backtrack(String str, int opened, int closed) {
        if (opened == closed && opened == N) {
            result.add(str);
            return;
        }

        if (closed > opened) return;

        if (opened < N) {
            backtrack(str + "(", opened + 1, closed);
        }

        backtrack(str + ")", opened, closed + 1);

    }
}
