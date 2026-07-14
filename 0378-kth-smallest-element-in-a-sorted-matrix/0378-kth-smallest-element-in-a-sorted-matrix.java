class Solution {

    private boolean countElements(int[][] matrix, int m, int n, int k, int num) {
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] <= num) {
                count += n;
                continue;
            }
            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix[i][mid] <= num) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            count += low;
        }

        return count >= k;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countElements(matrix, m, n, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}