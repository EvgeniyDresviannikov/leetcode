package medium.monotonic.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{30,60,90})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        // Monotonic decreasing stack
        Stack<Pair> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = temperatures.length-1; i > -1 ; i--) {
            int val = temperatures[i];
            while (!stack.isEmpty() && stack.peek().value <= val) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek().index - i;
            }

            stack.push(new Pair(i, val));
        }

        return result;
    }
}

class Pair {
    int index;
    int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
