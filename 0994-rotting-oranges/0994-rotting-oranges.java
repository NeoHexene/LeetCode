/*
INTUITION:
We are given a grid where:
0 → empty cell
1 → fresh orange
2 → rotten orange

Each minute, any fresh orange adjacent (up/down/left/right) to a rotten one becomes rotten.

This is a classic **multi-source BFS** problem:
- All rotten oranges are starting points (sources)
- Infection spreads level by level (minute by minute)

-----------------------------------------------------

BRUTE FORCE APPROACH:

Simulate minute by minute:
- For each minute, scan entire grid
- Convert adjacent fresh oranges

Time Complexity: O((m*n)^2) → very slow

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Use BFS:
- Add all rotten oranges to queue initially
- Process them level by level
- Each level = 1 minute

-----------------------------------------------------

IMPLEMENTED LOGIC:

1. Count fresh oranges and add all rotten ones to queue
2. If no fresh oranges → return 0
3. Run BFS:
   - For each level:
       → process all nodes in queue
       → rot adjacent fresh oranges
       → add newly rotten oranges to queue
   - increment time after each level
4. If all fresh oranges are rotted → return time
   else → return -1

-----------------------------------------------------

WHY TIME STARTS FROM -1:

We increment time AFTER processing each level.

Initial state:
- Queue already contains all initially rotten oranges
- But no time has passed yet

If we start time = 0:
- First BFS level (initial rotten oranges) would incorrectly count as 1 minute

So we start with:
time = -1

Then:
- After first level → time = 0 (correct: no time elapsed yet)
- After second level → time = 1
- and so on...

This ensures accurate minute counting.

-----------------------------------------------------

TIME COMPLEXITY:
O(m * n)

SPACE COMPLEXITY:
O(m * n)
*/

class Solution {
    public int orangesRotting(int[][] grid) {

        int freshOranges = 0;

        // Queue for BFS (stores coordinates of rotten oranges)
        Queue<int[]> q = new ArrayDeque<>();

        // Step 1: Initialize queue and count fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1) {
                    freshOranges += 1; // count fresh oranges
                }

                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j }); // add rotten oranges
                }
            }
        }

        // If no fresh oranges, no time needed
        if (freshOranges == 0) {
            return 0;
        }

        int time = -1; // explained above

        // BFS traversal
        while (!q.isEmpty()) {

            int size = q.size(); // number of oranges to process this minute

            while (size > 0) {

                int[] curr = q.poll();

                // 4 possible directions
                int[][] directions = new int[][] {
                        { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
                };

                for (int[] dir : directions) {

                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    // Check boundaries and skip invalid cells
                    if (nr < 0 || nc < 0 ||
                        nr >= grid.length || nc >= grid[nr].length ||
                        grid[nr][nc] == 2 || grid[nr][nc] == 0) {
                        continue;
                    }

                    // Rot the fresh orange
                    grid[nr][nc] = 2;
                    freshOranges--;

                    // Add to queue for next minute
                    q.offer(new int[] { nr, nc });
                }

                size--;
            }

            // One minute passed after processing current level
            time += 1;
        }

        // If all oranges rotted → return time, else -1
        return freshOranges == 0 ? time : -1;
    }
}