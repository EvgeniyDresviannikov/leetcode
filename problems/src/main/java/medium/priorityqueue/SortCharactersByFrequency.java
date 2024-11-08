package medium.priorityqueue;

import java.util.*;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> o2.cnt - o1.cnt);
        freq.entrySet().forEach(entry -> queue.add(new Pair(entry.getKey(), entry.getValue())));

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Pair pop = queue.poll();
            for (int i = 0; i < pop.cnt; i++) {
                sb.append(pop.c);
            }
        }

        return sb.toString();
    }
}

class Pair {
    char c;
    int cnt;

    public Pair(char c, int cnt) {
        this.c = c;
        this.cnt = cnt;
    }
}