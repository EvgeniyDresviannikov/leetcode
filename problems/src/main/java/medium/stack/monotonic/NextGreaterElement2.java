package medium.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElement2().nextGreaterElements(new int[]{5,4,3,2,1})));
    }

    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
        }

        return res;
    }
}
