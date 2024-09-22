package medium.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MiniParser {

    public static void main(String[] args) {
        NestedInteger res = new MiniParser().deserialize("[123,[456,[789]]]");
        System.out.println(res);
    }

    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();

        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));

        NestedInteger curr = null;
        String currentValue = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
            }  else if (c == ']') {
                if (!currentValue.isEmpty()) {
                    curr.add(new NestedInteger(Integer.parseInt(currentValue)));
                    currentValue = "";
                }
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }

            } else if (c == ',') {
                if (!currentValue.isEmpty()) {
                    curr.add(new NestedInteger(Integer.parseInt(currentValue)));
                    currentValue = "";
                }

            } else {
                currentValue += c;
            }
        }

        return curr;
    }
}




class NestedInteger{

    Integer integerValue;
    List<NestedInteger> nestedIntegerValue;

    public NestedInteger() {
        nestedIntegerValue = new ArrayList<>();
    }

    public NestedInteger(int value) {
        integerValue = value;
    }

    public boolean isInteger() {
        return integerValue != null;
    }

    public Integer getInteger() {
        return integerValue;
    }

    public void setInteger(int value) {
        integerValue = value;
    }

    public void add(NestedInteger ni) {
        nestedIntegerValue.add(ni);
    }


    public List<NestedInteger> getList() {
        return nestedIntegerValue;
    }
}
