package medium.string;


public class WordSearch {
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(new char[][]{{'A','B','C','E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
    public boolean exist(char[][] board, String word) {
        int rowLength = board.length;
        int colLength = board[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == word.charAt(0)) {
                    var res = backTrack(board, i, j, 0, word);
                    if (res) return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, int row, int col, int wordIndex, String word) {
        int rowLength = board.length;
        int colLength = board[0].length;

        if (wordIndex >= word.length()) return true;

        if (row >= rowLength || col >= colLength || row < 0 || col < 0
            || board[row][col] != word.charAt(wordIndex)) {
            return false;
        }

        board[row][col] = '#';

        int[] shiftRow = new int[] {-1, 0, 0, 1};
        int[] shiftCol = new int[] {0, 1, -1, 0};

        for (int k = 0; k < 4; k++) {
            var res = backTrack(board, row + shiftRow[k], col + shiftCol[k], wordIndex+1, word);
            board[row][col] = word.charAt(wordIndex);
            if (res) return true;
        }

        return false;

    }

}
