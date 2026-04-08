/*
INTUITION:
We need to check whether a given 9x9 Sudoku board is valid.

Rules:
1. Each row must have unique digits (1–9)
2. Each column must have unique digits (1–9)
3. Each 3x3 sub-box must have unique digits (1–9)

Instead of checking repeatedly, we store what we have seen using boolean arrays.

-----------------------------------------------------

APPROACH:

We use 3 tracking structures:

1. rows[r][num]   → has number appeared in row r?
2. cols[c][num]   → has number appeared in column c?
3. boxes[b][num]  → has number appeared in box b?

If we ever see the same number again in the same row/col/box → invalid

-----------------------------------------------------

BOX INDEX DERIVATION (IMPORTANT):

The board is divided into 3x3 boxes:

(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)
(2,0) (2,1) (2,2)

Each cell (r, c) belongs to:
- row group = r / 3
- col group = c / 3

So each box has coordinates:
(rowGroup, colGroup)

We need to convert this 2D box position into a 1D index (0 to 8).

We use standard 2D → 1D flattening:

index = row * number_of_columns + col

Here:
- row = r / 3
- col = c / 3
- number_of_columns = 3

So:
boxIdx = (r / 3) * 3 + (c / 3)

-----------------------------------------------------

TIME COMPLEXITY:
O(1) → always 9x9 grid

SPACE COMPLEXITY:
O(1)
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {

        // rows[r][num] → whether 'num' is already used in row r
        boolean[][] rows = new boolean[9][9];

        // cols[c][num] → whether 'num' is already used in column c
        boolean[][] cols = new boolean[9][9];

        // boxes[b][num] → whether 'num' is already used in box b
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {

                // Skip empty cells
                if (board[r][c] != '.') {

                    // Convert character '1'–'9' to index 0–8
                    int num = board[r][c] - '1';

                    /*
                     * Compute which 3x3 box this cell belongs to
                     *
                     * Step 1:
                     * r / 3 → gives box row (0,1,2)
                     * c / 3 → gives box column (0,1,2)
                     *
                     * Step 2:
                     * Convert (row, col) → single index using:
                     * index = row * width + col
                     *
                     * Here width = 3
                     *
                     * So:
                     * boxIdx = (r / 3) * 3 + (c / 3)
                     */
                    int boxIdx = (r / 3) * 3 + (c / 3);

                    // If already seen in row, column, or box → invalid
                    if (rows[r][num] || cols[c][num] || boxes[boxIdx][num]) {
                        return false;
                    }

                    // Mark number as seen
                    rows[r][num] = true;
                    cols[c][num] = true;
                    boxes[boxIdx][num] = true;
                }
            }
        }

        return true;
    }
}