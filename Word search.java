class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index) {

        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Current character doesn't match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Try 4 directions
        boolean found =
            dfs(board, word, row - 1, col, index + 1) ||  // Up
            dfs(board, word, row + 1, col, index + 1) ||  // Down
            dfs(board, word, row, col - 1, index + 1) ||  // Left
            dfs(board, word, row, col + 1, index + 1);    // Right

        // Backtrack
        board[row][col] = temp;

        return found;
    }
}
