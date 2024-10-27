package medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(new ArrayList<>(), new boolean[nums.length], nums, result);

        return result;

    }

    private void backtrack(List<Integer> perm, boolean[] used, int[] nums, List<List<Integer>> result) {
        if (perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                perm.add(nums[i]);
                used[i] = true;
                backtrack(perm, used, nums, result);
                used[i] = false;
                perm.remove(Integer.valueOf(nums[i]));
            }
        }
    }
}
