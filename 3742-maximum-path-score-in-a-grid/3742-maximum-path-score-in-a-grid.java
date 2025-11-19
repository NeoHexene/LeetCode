class Solution {
    
    Integer[][][] dp;
    
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n][k+1];
        int startCost = grid[0][0] == 0 ? 0 : 1;
        return dfs(0,0,startCost,grid,k);
    }

    private int dfs(int row, int col, int currCost, int[][] grid, int k) {
        if (currCost > k) {
            return -1;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }
        if (dp[row][col][currCost] != null) {
            return dp[row][col][currCost];
        }
        int best = -1;
        if (col + 1 <= grid[0].length - 1) {
            int newCost = currCost + (grid[row][col + 1] == 0 ? 0 : 1);
            int newBest = grid[row][col] + dfs(row, col + 1, newCost, grid, k);
            if (newBest > 0) {
                best = Math.max(best, newBest);
            }
        }
        if (row + 1 <= grid.length - 1) {
            int newCost = currCost + (grid[row + 1][col] == 0 ? 0 : 1);
            int newBest = grid[row][col] + dfs(row + 1, col, newCost, grid, k);
            if (newBest > 0) {
                best = Math.max(best, newBest);
            }
        }
        return dp[row][col][currCost] = best;
    }
}