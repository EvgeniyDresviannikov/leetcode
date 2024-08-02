package graph;

import java.util.*;

public class NumberOfIslands {
    char[][] board;

    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
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
                dfs(i, j, visited);
                counter++;
            }
        }

        return counter;
    }

    private void dfs(int i, int j,  Set<Map.Entry<Integer, Integer>> visited) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '0' || visited.contains(Map.entry(i, j))) {
            return;
        }

        board[i][j] = '0';

        dfs(i, j+1, visited);
        dfs(i, j-1, visited);
        dfs(i+1, j, visited);
        dfs(i-1, j, visited);

    }
}
