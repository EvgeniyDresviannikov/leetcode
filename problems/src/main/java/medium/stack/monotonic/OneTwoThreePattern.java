package medium.stack.monotonic;

import java.util.Stack;

public class OneTwoThreePattern {

    public static void main(String[] args) {
        System.out.println(new OneTwoThreePattern().find132pattern(new int[]{-2,1,1,-2,1,1}));
    }

    public boolean find132pattern(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
                stack.pop();
            }

            if (!stack.isEmpty() && nums[i] > stack.peek()[1]) {
                return true;
            }

            stack.push(new int[]{nums[i], curMin});
            curMin = Math.min(curMin, nums[i]);
        }

        return false;
    }
}

