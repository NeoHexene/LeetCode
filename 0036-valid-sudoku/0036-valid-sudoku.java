class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1'; // 0 to 8 numbering
                    int boxIdx = (r / 3) * 3 + (c / 3); // row major based indexing

                    if (rows[r][num] || cols[c][num] || boxes[boxIdx][num]) {
                        return false;
                    }

                    rows[r][num] = cols[c][num] = boxes[boxIdx][num] = true;
                }
            }
        }

        return true;
    }
}