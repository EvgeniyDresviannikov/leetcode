package medium.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{0, 0, 1, -1}, 0));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);


        int res = 0;
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;
            res += map.getOrDefault(diff, 0);
            map.put(curSum,  map.getOrDefault(curSum, 0) + 1);
        }

        return res;
    }
}
