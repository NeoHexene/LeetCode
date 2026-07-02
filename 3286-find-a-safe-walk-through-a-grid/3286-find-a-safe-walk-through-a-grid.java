class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size(), n = grid.get(0).size();

        Deque<int[]> dq = new LinkedList<>();
        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dq.offerFirst(new int[]{0, 0});
        dist[0][0] = grid.get(0).get(0);

        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            
            int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

            for (int[] dir : directions) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if (nr < 0 || nc < 0 || nr == m || nc == n) {
                    continue;
                }

                int newDamage = dist[curr[0]][curr[1]] + grid.get(nr).get(nc);

                if (newDamage < dist[nr][nc]) {
                    dist[nr][nc] = newDamage;
                    if (grid.get(nr).get(nc) == 1) {
                        dq.offerLast(new int[]{nr, nc});
                    } else {
                        dq.offerFirst(new int[]{nr, nc});
                    }
                }

            }
        }

        return health - dist[m - 1][n - 1] >= 1;
    }
}