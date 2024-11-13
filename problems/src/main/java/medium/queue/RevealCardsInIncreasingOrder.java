package medium.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RevealCardsInIncreasingOrder {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RevealCardsInIncreasingOrder().deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7})));
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        int[] res = new int[deck.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            deque.add(i);
        }

        Arrays.sort(deck);

        for (int i = 0; i < deck.length; i++) {
            int val = deck[i];
            int idx = deque.pollFirst();
            res[idx] = val;
            if (!deque.isEmpty()) {
                deque.addLast(deque.pollFirst());
            }

        }

        return res;
    }
}
