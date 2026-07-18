class Solution {
    public int numSpecial(int[][] grid) {

        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    res++;
                }
            }

        }

        return res;

    }
}