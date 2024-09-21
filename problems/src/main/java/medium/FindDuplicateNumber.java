package medium;

import java.util.Arrays;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        System.out.println(new FindDuplicateNumber().findDuplicate(new int[]{1,3,4,2,2}));
    }

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) break;
        }

        slow = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];

        }

        return slow;
    }
}
