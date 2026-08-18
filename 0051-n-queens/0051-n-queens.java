class Solution {

    private List<String> generateAnsList(boolean[][] placed, int n) {

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (placed[i][j]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            ans.add(sb.toString());
        }

        return ans;
    }

    private boolean isSafe(boolean[] cols, boolean leftDiagonal[], boolean rightDiagonal[], int row, int col, int n) {
        return !(leftDiagonal[n - 1 + row - col] || rightDiagonal[row + col] || cols[col]);
    }

    private void dfs(int n, int row, boolean[][] placed, boolean[] cols, boolean[] leftDiagonal, boolean[] rightDiagonal, List<List<String>> res) {

        if (row == n) {
            res.add(new ArrayList<>(generateAnsList(placed, n)));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(cols, leftDiagonal, rightDiagonal, row, i, n)) {
                placed[row][i] = true;
                rightDiagonal[row + i] = true;
                leftDiagonal[n - 1 + row - i] = true;
                cols[i] = true;
                dfs(n, row + 1, placed, cols, leftDiagonal, rightDiagonal, res);
                placed[row][i] = false;
                rightDiagonal[row + i] = false;
                leftDiagonal[n - 1 + row - i] = false;
                cols[i] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(n, 0, new boolean[n][n], new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], res);
        return res;
    }
}