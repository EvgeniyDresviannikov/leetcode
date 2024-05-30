package easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (values.containsKey(diff)) {
                return new int[]{values.get(diff), i};
            } else {
                values.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
