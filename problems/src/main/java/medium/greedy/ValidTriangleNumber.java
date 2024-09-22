package medium.greedy;

import java.util.Arrays;

public class ValidTriangleNumber {

    int result = 0;

    public static void main(String[] args) {
        System.out.println(new ValidTriangleNumber().triangleNumber(new int[]{4,2,3,4}));
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int res = 0;
        for (int k = nums.length - 1; k > 1; k--) {
            int i = 0;
            int j = k - 1;

            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    res += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }

}
