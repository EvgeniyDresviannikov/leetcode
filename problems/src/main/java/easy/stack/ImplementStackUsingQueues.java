package easy.stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        ImplementStackUsingQueues implementStackUsingQueues = new ImplementStackUsingQueues();
        MyStack obj = new MyStack();
        obj.push(7);
        obj.push(5);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.pop();
        boolean param_5 = obj.empty();

        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
    }
}


class MyStack {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    int size = 0;
    int top;

    public MyStack() {

    }

    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.add(x);
        } else {
            queue2.add(x);
        }
        top = x;
        size++;
    }

    public int pop() {
        if (queue1.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (i == size-1) {
                    size--;
                    return queue2.poll();
                }
                top = queue2.poll();
                queue1.add(top);
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (i == size-1) {
                    size--;
                    return queue1.poll();
                }
                top = queue1.poll();
                queue2.add(top);
            }
        }
        return 0;
    }

    public int top() {
       return top;
    }

    public boolean empty() {
        return size == 0;
    }
}
