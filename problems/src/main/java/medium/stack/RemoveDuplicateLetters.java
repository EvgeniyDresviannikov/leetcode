package medium.stack;

import java.util.*;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> lookup = new HashMap<>();
        Set<Character> seen = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            lookup.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (seen.contains(c)) continue;

            while (!stack.isEmpty() && (int) stack.peek() > (int) c && lookup.get(stack.peek()) > i) {
                seen.remove(stack.peek());
                stack.pop();
            }

            stack.push(c);
            seen.add(c);
        }

        StringBuilder b = new StringBuilder();
        while (!stack.isEmpty()) {
            b.append(stack.pop());
        }

        return b.reverse().toString();
    }
}
