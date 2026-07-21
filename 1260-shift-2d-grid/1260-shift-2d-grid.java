class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k = k % (m * n);

        for (int i = 0; i < k; i++) {
            
            int lastRowCol = grid[m - 1][n - 1];

            for (int r = m - 1; r >= 0; r--) {
                int prevLast = -1;
                if (r > 0) {
                    prevLast = grid[r - 1][n - 1];
                }
                for (int c = n - 1; c > 0; c--) {
                    grid[r][c] = grid[r][c - 1];
                }
                if (r == 0) {
                    grid[r][0] = lastRowCol;
                }
                if (r > 0) {
                    grid[r][0] = prevLast;
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                res.get(i).add(grid[i][j]);
            }
        }

        return res;
    }
}