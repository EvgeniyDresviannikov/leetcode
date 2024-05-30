package easy.priorityqueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class RelativeRanks {
    public static void main(String[] args) {
        RelativeRanks relativeRanks = new RelativeRanks();
        System.out.println(Arrays.toString(relativeRanks.findRelativeRanks(new int[]{10,3,8,9,4})));
    }

    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Win> queue = new PriorityQueue<>(Collections.reverseOrder());
        String[] answers = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            queue.add(new Win(score[i], i));
        }

        for (int i = 1; i <= score.length; i++) {

            if (i == 1) {
                Win first = queue.poll();
                answers[first.index] = "Gold Medal";
                continue;
            }

            if (i == 2) {
                Win second = queue.poll();
                answers[second.index] = "Silver Medal";
                continue;
            }

            if (i == 3) {
                Win third = queue.poll();
                answers[third.index] = "Bronze Medal";
                continue;
            }

            Win cur = queue.poll();
            answers[cur.index] = ""+i;
        }


        return answers;
    }
}

class Win implements Comparable<Win> {
    int val;
    int index;

    public Win(int val, int index) {
        this.val = val;
        this.index = index;
    }


    @Override
    public String toString() {
        return "Win{" +
            "val=" + val +
            ", index=" + index +
            '}';
    }

    @Override
    public int compareTo(Win o) {
        return this.val - o.val;
    }
}
