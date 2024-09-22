package medium.greedy;

import java.util.Arrays;

public class LargestNumber {

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{3,30,34,5,9}));
    }

    public String largestNumber(int[] nums) {

        String[] arrStr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

        String[] sorted = Arrays.stream(arrStr)
                .sorted(
                        (a, b) -> b.concat(a).compareTo(a.concat(b))
                ).toArray(String[]::new);

        if (sorted[0].equals("0")) return "0";

        return String.join("", sorted);

    };


}
