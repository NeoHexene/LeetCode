class Solution {

    private boolean isSafe(int[][] distToThief, int safeDist) {
        int n = distToThief.length;

        Queue<int[]> bfs = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        if(distToThief[0][0] < safeDist) {
            return false;
        }

        bfs.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!bfs.isEmpty()) {
            int curr[] = bfs.poll();

            if (curr[0] == n - 1 && curr[1] == n - 1) {
                return true;
            }

            int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

            for (int[] dir : directions) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if (nr < 0 || nc < 0 || nr == n || nc == n || visited[nr][nc] || distToThief[nr][nc] < safeDist) {
                    continue;
                }

                visited[nr][nc] = true;
                bfs.offer(new int[]{nr, nc});
            }
        }

        return false;

    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        boolean[][] visited = new boolean[n][n];
        int[][] distToThief = new int[n][n];
        Queue<int[]> bfs = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    bfs.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int dist = 1;

        while (!bfs.isEmpty()) {
            int qsize = bfs.size();
            while (qsize-- > 0) {
                int curr[] = bfs.poll();
                int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                for (int[] dir : directions) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr == n || nc == n || nr < 0 || nc < 0 || visited[nr][nc]) {
                        continue;
                    }
                    distToThief[nr][nc] = dist;
                    visited[nr][nc] = true;
                    bfs.offer(new int[]{nr, nc});
                }
            }
            dist++;
        }

        int low = 0, high = dist;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isSafe(distToThief, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}