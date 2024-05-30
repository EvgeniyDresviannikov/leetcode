package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        result.forEach(list -> System.out.println(Arrays.toString(list.toArray())));
    }

    // n =4, k = 2
    // [[1,2], [1,3], [1,4], [2,3], [2,4], [3,4]]
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(curr, 1, res, n, k);

        return res;

    }

    static void backtrack(List<Integer> curr, int firstNum, List<List<Integer>> res, int n, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int num = firstNum; num <= n; num++) {
            curr.add(num);
            backtrack(curr, num+1, res, n, k);
            curr.remove(curr.size()-1);
        }

    }

}
