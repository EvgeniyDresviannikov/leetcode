package medium.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class SnakeGame {

    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(3, 2, new int[][]{
                {1,2}, {0,1}
        });

        System.out.println(snakeGame.move('R'));
        System.out.println(snakeGame.move('D'));
        System.out.println(snakeGame.move('R'));
        System.out.println(snakeGame.move('U'));

    }

    private Deque<Pair> foodQueue;
    private Deque<Pair> snakeQueue;
    private int score;
    private int width;
    private int height;

    SnakeGame(int width, int height, int[][] foods) {
        foodQueue = new ArrayDeque<>();
        snakeQueue = new ArrayDeque<>();
        for (int[] food : foods) {
            foodQueue.add(new Pair(food[0], food[1]));
        }
        snakeQueue.add(new Pair(0, 0));
        score = 0;
        this.width = width;
        this.height = height;
    }

    int move(Character c) {
        Pair head = snakeQueue.peekFirst();
        Pair newPos = new Pair(head.r, head.c);

        if (c == 'U') {
            newPos.r--;
        } else if (c == 'D') {
            newPos.r++;
        } else if (c == 'R') {
            newPos.c++;
        } else if (c == 'L') {
            newPos.c--;
        }

        // validate position
        if (newPos.c < 0 || newPos.c > this.width-1 || newPos.r < 0 || newPos.r > height-1) return -1;

        if (!foodQueue.isEmpty() && foodQueue.peek().equals(newPos)) {
            snakeQueue.addFirst(newPos);
            foodQueue.poll();
            score++;
        } else {
            snakeQueue.pollLast();

            // check if snake don't cross itself
            if (snakeQueue.contains(newPos)) {
                return -1;
            } else {
                snakeQueue.addFirst(newPos);
            }
        }

        return score;
    }
}

class Pair {
    int r;
    int c;
    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return r == pair.r && c == pair.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }
}