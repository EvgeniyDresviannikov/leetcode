package array.string.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (count.containsKey(nums[i])) {
                int val = count.get(nums[i]);
                val++;
                if (val > len/2) {
                    return nums[i];
                }
                count.put(nums[i], val);
            } else {
                count.put(nums[i], 1);
            }
        }

        return -1;
    }
}
