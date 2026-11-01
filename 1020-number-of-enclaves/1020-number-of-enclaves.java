class Solution {

    public int numEnclaves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] temp = new int[m][n];
    
        for (int i = 0; i < m; i++) {
            temp[i] = grid[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                q.offer(new int[]{0, i});
                temp[0][i] = 0;
            }
            if (grid[m - 1][i] == 1) {
                q.offer(new int[]{m - 1, i});
                temp[m - 1][i] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                q.offer(new int[]{i, 0});
                temp[i][0] = 0;
            }
            if (grid[i][n - 1] == 1) {
                q.offer(new int[]{i, n - 1});
                temp[i][n - 1] = 0;
            }
        }

        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {

            int curr[] = q.poll();

            for (int[] dir : direction) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || temp[nr][nc] == 0) {
                    continue;
                }

                temp[nr][nc] = 0;
                q.offer(new int[]{nr, nc});
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 1) {
                    count += 1;
                }
            }
        }

        return count;
    }
}