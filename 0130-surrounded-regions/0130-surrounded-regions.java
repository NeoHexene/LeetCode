class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] temp = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            if(board[0][i] == 'O') {
                q.offer(new int[]{0, i});
                temp[0][i] = true;
            }
            if (board[m - 1][i] == 'O') {
                q.offer(new int[]{m - 1, i});
                temp[m - 1][i] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
                temp[i][0] = true;
            }
            if (board[i][n - 1] == 'O') {
                q.offer(new int[]{i, n - 1});
                temp[i][n - 1] = true;
            }
        }
        
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            
            int[] curr = q.poll();

            for (int[] dir : direction) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || board[nr][nc] == 'X' || temp[nr][nc]) {
                    continue;
                }

                q.offer(new int[]{nr, nc});
                temp[nr][nc] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!temp[i][j]) {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }
}