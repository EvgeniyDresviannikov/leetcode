package array.string.medium;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2,3,1,1,4}));
    }

    public boolean canJump(int[] nums) {
        int targetIndex = nums.length-1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (targetIndex <= i + nums[i]) {
                targetIndex = i;
            }
        }

        return targetIndex == 0;
    }

}
