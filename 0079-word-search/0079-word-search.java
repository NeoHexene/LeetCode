class Solution {

    // we can temporarily update the input board to keep track of visited if we want to optimize the space used.

    private boolean dfs(char[][] board, String word, int idx, int row, int col, boolean visited[][]) {
        if (idx == word.length()) {
            return true;
        }
        if (row == board.length || row < 0 || col == board[row].length || col < 0 || board[row][col] != word.charAt(idx) || visited[row][col]) {
            return false;
        }
        
        visited[row][col] = true;
        
        boolean found = dfs(board, word, idx + 1, row + 1, col, visited) || dfs(board, word, idx + 1, row, col + 1, visited) || dfs(board, word, idx + 1, row - 1, col, visited) || 
        dfs(board, word, idx + 1, row, col - 1, visited);

        visited[row][col] = false;
        
        return found;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}