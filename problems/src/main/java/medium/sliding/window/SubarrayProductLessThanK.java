package medium.sliding.window;

public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int left = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (left <= i && product >= k) {
                product /= nums[left];
                left++;
            }
            res += i - left + 1;
        }

        return res;
    }
}
