package medium.queue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueNumber {

    public static void main(String[] args) {
        FirstUniqueNumber firstUniqueNumber = new FirstUniqueNumber(new int[]{2,3,5});
        System.out.println(firstUniqueNumber.showFirstUnique());
        System.out.println(firstUniqueNumber.showFirstUnique());
        firstUniqueNumber.add(2);
        System.out.println(firstUniqueNumber.showFirstUnique());
        System.out.println(firstUniqueNumber.showFirstUnique());
        firstUniqueNumber.add(5);
        System.out.println(firstUniqueNumber.showFirstUnique());
        firstUniqueNumber.add(3);
        System.out.println(firstUniqueNumber.showFirstUnique());

        firstUniqueNumber.add(4);
        System.out.println(firstUniqueNumber.showFirstUnique());

    }

    Map<Integer, Integer> freq;
    Queue<Integer> queue;

    public FirstUniqueNumber(int[] nums) {
        freq = new HashMap<>();
        queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            queue.add(val);
        }
    }

    int showFirstUnique() {

        while (!queue.isEmpty() && freq.get(queue.peek()) != 1) {
            queue.poll();
        }
        return queue.isEmpty() ? -1 : queue.peek();
    }

    void add(int value) {
        freq.put(value, freq.getOrDefault(value, 0) + 1);
        if (freq.get(value) == 1) {
            queue.add(value);
        }

    }
}
