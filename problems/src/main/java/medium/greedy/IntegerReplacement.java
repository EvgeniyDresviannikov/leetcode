package medium.greedy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class IntegerReplacement {

    public static void main(String[] args) {
        System.out.println(new IntegerReplacement().integerReplacement(7));
    }

    public int integerReplacement(int n) {
        int counter = 0;
        Queue<Long> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();
        queue.add((long) n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long num = queue.poll();

                if (num == 1) return counter;

                if (num % 2 == 0) {
                    if (!visited.contains(num / 2)) {
                        queue.add(num / 2);
                        visited.add(num / 2);
                    }

                } else {
                    if (!visited.contains(num + 1)) {
                        queue.add(num + 1);
                        visited.add(num + 1);
                    }

                    if (!visited.contains(num - 1)) {
                        queue.add(num - 1);
                        visited.add(num - 1);
                    }
                }
            }
            counter++;
        }

        return counter;
    }
}
