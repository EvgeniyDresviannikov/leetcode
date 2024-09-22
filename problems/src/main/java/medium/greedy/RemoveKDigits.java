package medium.greedy;

import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {
        Stack<String> stack = new Stack<>();

        for (String c : num.split("")) {
            while (!stack.isEmpty() && k > 0 && stack.peek().compareTo(c) > 0) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        if (sb.isEmpty()) return "0";

        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }



        return sb.toString();
    }
}
