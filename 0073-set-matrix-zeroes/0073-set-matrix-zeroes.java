class Solution {
    public void setZeroes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean firstRowZero = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[0][j] = 0;
                    if (i > 0) {
                        grid[i][0] = 0;
                    } else {
                        firstRowZero = true;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[0][j] == 0 || grid[i][0] == 0) {
                    grid[i][j] = 0;
                }
            }
        }

        if (grid[0][0] == 0) {
            for (int i = 0; i < m; i++) {
                grid[i][0] = 0;
            }
        }

        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                grid[0][j] = 0;
            }
        }
    }
}