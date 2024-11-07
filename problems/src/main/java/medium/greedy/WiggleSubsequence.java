package medium.greedy;

public class WiggleSubsequence {

    public static void main(String[] args) {
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int up = 1;
        int down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                up = down + 1;
            } else if (nums[i] < nums[i-1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }
}
