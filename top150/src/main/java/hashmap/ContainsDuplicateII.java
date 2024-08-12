package hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (visited.containsKey(val) && i - visited.get(val) <= k) {
                return true;
            }

            visited.put(val, i);
        }

        return false;
    }
}
