class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int rowL = 0, rowH = m - 1;
        int rowIdx = -1;

        while (rowL <= rowH) {
            int rowM = rowL + (rowH - rowL) / 2;

            if (matrix[rowM][0] <= target && target <= matrix[rowM][n - 1]) {
                rowIdx = rowM;
                break;
            }
            if (matrix[rowM][0] > target) {
                rowH = rowM - 1;
            } else {
                rowL = rowM + 1;
            }
        }

        if (rowIdx == -1) {
            return false;
        }

        int colL = 0, colH = n - 1;

        while (colL <= colH) {
            int colM = colL + (colH - colL) / 2;

            if (matrix[rowIdx][colM] == target) {
                return true;
            }

            if (matrix[rowIdx][colM] > target) {
                colH = colM - 1;
            } else {
                colL = colM + 1;
            }
        }

        return false;
    }
}