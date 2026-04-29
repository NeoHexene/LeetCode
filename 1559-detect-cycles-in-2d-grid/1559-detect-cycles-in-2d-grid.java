class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }

                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j, -1, -1});
                visited[i][j] = true;

                while (!q.isEmpty()) {
                    int curr[] = q.poll();
                    int r = curr[0], c = curr[1], pr = curr[2], pc = curr[3];
                    int directions[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
                    
                    for (int[] dir : directions) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];

                        if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[r][c] != grid[nr][nc]) {
                            continue;
                        }
                        if (visited[nr][nc]) {
                            if (nr != pr || nc != pc) {
                                return true;
                            }
                        } else {
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