package hard;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> lst = new ArrayList<>();

        for (int i = 1; i < n ; i++) {
            lst.add(i);
            fact = fact * i;
        }

        lst.add(n);
        k = k - 1;
        StringBuilder res = new StringBuilder();
        while (true) {
            int idx = k / fact;
            res.append(lst.get(idx));
            lst.remove(idx);

            if (lst.isEmpty()) break;

            k = k % fact;
            fact = fact / lst.size();
        }

        return res.toString();
    }
}
