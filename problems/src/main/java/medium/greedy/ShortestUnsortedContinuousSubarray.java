package medium.greedy;

import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1,3,2,4,5}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len <= 1) return 0;

        int left = len;
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        int i = 0;

        while (i < len) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int pop = stack.pop();
                left = Math.min(left, pop);
                max = Math.max(max, nums[pop]);
            }

            stack.push(i);
            i++;
        }

        if (left == len) return 0;

        int right = len-1;
        while (right > -1) {
            if (nums[right] < max) {
                break;
            }
            right--;
        }

        return right - left + 1;
    }

}
