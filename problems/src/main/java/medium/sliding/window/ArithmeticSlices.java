package medium.sliding.window;

public class ArithmeticSlices {

    public static void main(String[] args) {
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[]{1,2,3,4,6,8}));
    }

    public int numberOfArithmeticSlices(int[] nums) {

        if (nums.length < 3) return 0;

        int[] dp = new int[nums.length-1];

        for (int i = 1; i < nums.length; i++) {
            dp[i-1] = nums[i] - nums[i-1];
        }

        int res = 0;
        int m = 1;

        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == dp[i-1]) {
                res += m;
                m += 1;
            } else {
                m = 1;
            }
        }

        return res;

    }
}
