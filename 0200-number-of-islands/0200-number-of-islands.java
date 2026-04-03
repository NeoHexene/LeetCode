class Solution {
    public int numIslands(char[][] grid) {

        // This will store the total number of islands
        int count = 0;

        // Traverse every cell in the grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {

                // If we find land ('1'), it means we found a new island
                if (grid[row][col] == '1') {

                    // Increment island count
                    count++;

                    // Explore the entire island using BFS
                    bfs(grid, row, col);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int row, int col) {

        // Queue for BFS traversal
        Queue<int[]> q = new LinkedList<>();

        // Add the starting cell (first land cell found)
        q.offer(new int[]{row, col});

        // Mark it as visited by converting it to '0'
        grid[row][col] = '0';

        // Directions: down, up, right, left
        int[][] directions = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        // Process all connected land cells
        while (!q.isEmpty()) {

            // Get the current cell
            int[] curr = q.poll();

            // Explore all 4 directions
            for (int[] dir : directions) {

                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                // Check boundaries and ensure it's land ('1')
                if (newRow < 0 || newRow >= grid.length ||
                    newCol < 0 || newCol >= grid[0].length ||
                    grid[newRow][newCol] == '0') {
                    continue;
                }

                // Add valid land cell to queue
                q.offer(new int[]{newRow, newCol});

                // Mark as visited to avoid revisiting
                grid[newRow][newCol] = '0';
            }
        }
    }
}