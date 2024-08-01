package graph;

import java.util.*;

public class NumberOfIslands {
    char[][] board;

    final static int[][] directions = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(new char[][]{
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}
        }));
    }

    public int numIslands(char[][] grid) {
        board = grid;
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        int counter = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '0' || visited.contains(Map.entry(i, j))) {
                    continue;
                }
                bfs(i, j, visited);
                counter++;
            }
        }

        return counter;
    }

    private void bfs(int i, int j,  Set<Map.Entry<Integer, Integer>> visited) {

        Queue<Map.Entry<Integer, Integer>> current = new ArrayDeque<>();
        Queue<Map.Entry<Integer, Integer>> next = new ArrayDeque<>();

        current.add(Map.entry(i, j));

        while (!current.isEmpty()) {
            Map.Entry<Integer, Integer> pop = current.poll();
            int row = pop.getKey();
            int col = pop.getValue();
            visited.add(Map.entry(row, col));

            for (int k = 0; k < directions.length; k++) {
                int r = row + directions[k][0];
                int c = col + directions[k][1];
                if (r > -1 && r < board.length && c > -1 && c < board[0].length && board[r][c] == '1' && !visited.contains(Map.entry(r, c))) {
                    next.add(Map.entry(r, c));
                }
            }

            if (current.isEmpty()) {
                while (!next.isEmpty()) {
                    current.add(next.poll());
                }
            }
        }
    }
}
