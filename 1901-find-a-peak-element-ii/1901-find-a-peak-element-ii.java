class Solution {

    private int maxElementRow(int[][] matrix, int m, int n, int col) {
        int max = -1;
        int maxIdx = -1;

        for (int i = 0; i < m; i++) {
            if (matrix[i][col] > max) {
                max = matrix[i][col];
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    public int[] findPeakGrid(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = maxElementRow(matrix, m, n, mid);

            int left = mid == 0 ? -1 : matrix[row][mid - 1];
            int right = mid == n - 1 ? -1 : matrix[row][mid + 1];

            if (left < matrix[row][mid] && matrix[row][mid] > right) {
                return new int[]{row, mid};
            }

            if (left > matrix[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return new int[]{0, 0};
    }
}