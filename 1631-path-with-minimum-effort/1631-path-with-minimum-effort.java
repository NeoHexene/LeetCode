class Solution {

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] diff = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        diff[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            
            int[] curr = pq.poll();
            int currdiff = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == m - 1 && col == n - 1) {
                return currdiff;
            }

            if (currdiff > diff[row][col]) {
                continue;
            }

            for (int i = 0; i < dr.length; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || diff[nr][nc] <= Math.max(currdiff, Math.abs(heights[row][col] - heights[nr][nc]))) {
                    continue;
                }

                pq.offer(new int[]{Math.max(currdiff, Math.abs(heights[row][col] - heights[nr][nc])), nr, nc});
                diff[nr][nc] = Math.max(currdiff, Math.abs(heights[row][col] - heights[nr][nc]));
            }
        }
        
        return -1;
    }
}