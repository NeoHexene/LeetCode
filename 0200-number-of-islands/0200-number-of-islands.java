class Solution {
    public int numIslands(char[][] grid) {
        // hold the number of islands discovered
        int count = 0;
        // to iterate rows
        for (int row = 0; row < grid.length; row += 1) {
            // to iterate cols
            for (int col = 0; col < grid[row].length; col += 1) {
                // check if it is an 1 or not
                if (grid[row][col] == '1') {
                    count += 1;
                    // traverse around the matrix to explore connected 1's
                    bfs(grid, row, col);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : directions) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];
                if (newRow >= grid.length || newRow < 0 || newCol >= grid[newRow].length || newCol < 0 || grid[newRow][newCol] == '0') {
                    continue;
                }
                q.offer(new int[]{newRow, newCol});
                grid[newRow][newCol] = '0';
            }
        }
        return;   
    }
}