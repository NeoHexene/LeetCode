class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        int[][] grid = new int[mat.length][mat[0].length];
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            
            int[] curr = q.poll();

            for (int[] dir : direction) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if (nr < 0 || nc < 0 || nr >= mat.length || nc >= mat[0].length || visited[nr][nc]) {
                    continue;
                }

                q.offer(new int[]{nr, nc, curr[2] + 1});
                visited[nr][nc] = true;
                grid[nr][nc] = curr[2] + 1;
            }
        }

        return grid;
    }
}