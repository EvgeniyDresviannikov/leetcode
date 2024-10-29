package medium.array;

import java.util.Arrays;

public class ReverseArrayInGroups {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ReverseArrayInGroups().reverseInGroups(new int[]{1,2,3,4,5,6,7,8}, 3)));
    }

    public int[] reverseInGroups(int[] nums, int k) {
        int len = nums.length;
        int groups = len % k == 0 ? len / k : 1 + len / k;

        for (int i = 0; i < groups; i++) {
            int left = i * k;
            int right = (i+1)*k - 1;
            if (right > len - 1) {
                right = len - 1;
            }

            while (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        return nums;
    }
}
