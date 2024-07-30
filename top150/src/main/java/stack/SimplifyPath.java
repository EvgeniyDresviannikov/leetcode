package stack;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/../"));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] items = path.split("/");

        for (int i = 0; i < items.length; i++) {
            String item = items[i];
            if (item.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (item.isEmpty() || item.equals(".") || item.equals("..")) {

            } else {
                stack.push(item);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            String item = stack.pop();
            res.insert(0, item);
            res.insert(0, "/");
        }

        return res.isEmpty() ? "/" : res.toString();
    }
}
