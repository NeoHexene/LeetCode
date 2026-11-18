class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int[] dr = new int[]{1, 0, -1, 0, 1, -1, 1, -1};
        int[] dc = new int[]{0, 1, 0, -1, 1, -1, -1, 1};

        dist[0][0] = 1;
        q.offer(new int[]{1, 0, 0}); // dist, row, col

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int currdist = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (currdist > dist[row][col]) {
                continue;
            }

            for (int i = 0; i < dr.length; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] == 1 || currdist + 1 >= dist[nr][nc]) {
                    continue;
                }

                q.offer(new int[]{currdist + 1, nr, nc});
                dist[nr][nc] = currdist + 1;

                if (nr == m - 1 && nc == n - 1) {
                    return dist[nr][nc];
                }
            }
        }

        return dist[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : dist[m - 1][n - 1];
    }
}