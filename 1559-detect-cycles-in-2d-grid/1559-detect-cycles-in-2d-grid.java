/*
INTUITION:

We need to detect whether there exists a cycle in the grid such that:
- All cells in the cycle have the same character
- Cycle length ≥ 4
- You can move in 4 directions (up, down, left, right)

Key idea:
Treat the grid as a graph:
- Each cell = node
- Edge exists if adjacent cells have same character

Then the problem becomes:
    Detect cycle in an undirected graph

-----------------------------------------------------

CORE IDEA (BFS WITH PARENT TRACKING):

While traversing:
- If we visit a neighbor that is already visited
- AND it is NOT the parent of current cell
→ we found a cycle

Why parent?
Because in undirected graph:
- we can always go back to where we came from
- that should NOT be treated as a cycle

-----------------------------------------------------

APPROACH:

1. Maintain a visited matrix
2. For each unvisited cell:
   - Start BFS
   - Store (row, col, parent_row, parent_col)
3. For each neighbor:
   - Skip out-of-bounds or different character
   - If visited:
        → check if it's NOT parent → cycle found
   - Else:
        → mark visited and push into queue

-----------------------------------------------------

WHY THIS WORKS:

- Ensures we only traverse same-character components
- Parent tracking avoids false cycle detection
- Visiting an already visited node (not parent) means we found a loop

-----------------------------------------------------

EDGE CASES:

1. Single cell → no cycle
2. All same characters but no loop → no cycle
3. Large connected region → BFS handles it efficiently
4. Cycle must be at least 4 cells → automatically ensured by logic

-----------------------------------------------------

TIME COMPLEXITY:
O(m * n)

- Each cell is visited once

SPACE COMPLEXITY:
O(m * n)

- visited matrix + queue

-----------------------------------------------------

PATTERN:

Graph traversal (BFS/DFS) + Cycle detection in undirected graph
*/

class Solution {
    public boolean containsCycle(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int[][] directions = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        // Traverse all cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Skip already visited cells
                if (visited[i][j]) {
                    continue;
                }

                // Start BFS from this cell
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j, -1, -1}); // row, col, parent row, parent col
                visited[i][j] = true;

                while (!q.isEmpty()) {

                    int[] curr = q.poll();
                    int r = curr[0], c = curr[1];
                    int pr = curr[2], pc = curr[3];

                    // Explore neighbors
                    for (int[] dir : directions) {

                        int nr = r + dir[0];
                        int nc = c + dir[1];

                        // Skip invalid or different character
                        if (nr < 0 || nc < 0 || nr >= m || nc >= n ||
                            grid[r][c] != grid[nr][nc]) {
                            continue;
                        }

                        // If already visited
                        if (visited[nr][nc]) {

                            // If not coming from parent → cycle detected
                            if (nr != pr || nc != pc) {
                                return true;
                            }

                        } else {
                            // Mark visited and continue BFS
                            visited[nr][nc] = true;
                            q.offer(new int[]{nr, nc, r, c});
                        }
                    }
                }
            }
        }

        return false;
    }
}