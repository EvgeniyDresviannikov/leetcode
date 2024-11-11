package medium.monotonic.stack;

import java.util.Stack;

public class OnlineStockSpan {
    Stack<int[]> stack;

    public static void main(String[] args) {
        OnlineStockSpan onlineStockSpan = new OnlineStockSpan();
        System.out.println(onlineStockSpan.next(100));
        System.out.println(onlineStockSpan.next(80));
        System.out.println(onlineStockSpan.next(60));
        System.out.println(onlineStockSpan.next(70));
        System.out.println(onlineStockSpan.next(60));
        System.out.println(onlineStockSpan.next(75));
        System.out.println(onlineStockSpan.next(85));
    }

    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        if (stack.isEmpty()) {
            stack.push(new int[]{price, 1});
        } else {
            int days = 1;
            while (stack.peek()[0] <= price) {
                days += stack.pop()[1];
            }
            stack.push(new int[]{price, days});
        }

        return stack.peek()[1];
    }
}
