package medium.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        System.out.println(new RottingOranges().orangesRotting(new int[][]{
                {0,2}
        }));
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] DIRECTIONS = new int[][] {
                {0,1}, {0, -1}, {1, 0}, {-1, 0}
        };

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int minutes = -1;
        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            int k = 0;
            while (k < size) {
                int[] pop = queue.poll();
                int i = pop[0];
                int j = pop[1];
                for (int l = 0; l < DIRECTIONS.length; l++) {
                    int neighborI = i + DIRECTIONS[l][0];
                    int neighborJ = j + DIRECTIONS[l][1];
                    if (isFresh(neighborI, neighborJ, grid)) {
                        grid[neighborI][neighborJ] = 2;
                        queue.add(new int[]{neighborI, neighborJ});
                    }
                }
                k++;
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes == -1 ? 0 : minutes;

    }

    private boolean isFresh(int i, int j, int[][] grid) {
        return i > -1 && j > -1 && i < grid.length && j < grid[0].length && grid[i][j] == 1;
    }
}
