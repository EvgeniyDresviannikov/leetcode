package medium.queue;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {

    public static void main(String[] args) {

    }

}

class NestedIterator implements Iterator<Integer> {
    Stack<Integer> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        Stack<Integer> reversedStack = new Stack<>();
        dfs(nestedList, reversedStack);
        while (!reversedStack.isEmpty()) {
            stack.push(reversedStack.pop());
        }
    }

    private void dfs(List<NestedInteger> nested, Stack<Integer> reversedStack) {
        for (int i = 0; i < nested.size(); i++) {
            NestedInteger item = nested.get(i);
            if (item.isInteger()) {
                reversedStack.push(item.getInteger());
            } else {
                dfs(item.getList(), reversedStack);
            }
        }
    }

    @Override
    public Integer next() {
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
 }
