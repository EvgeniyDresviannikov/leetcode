package medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        int numberOfCombination = (int) Math.pow(2, nums.length);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numberOfCombination; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (getBit(i, j)) {
                    subset.add(nums[j]);
                }
            }

            result.add(subset);
        }

        return result;
    }

    private boolean getBit(int num, int pos) {
        int tmp = 1 << pos;
        return (num & tmp) > 0;
    }
}
