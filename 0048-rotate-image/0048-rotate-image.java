class Solution {
    public void rotate(int[][] grid) {
        int top = 0, left = 0;
        int bottom = grid.length - 1, right = grid[0].length - 1;

        while (top <= bottom && left <= right) { 
            for (int i = 0; i < bottom - top; i++) {
                int temp = grid[top + i][left];
                grid[top + i][left] = grid[bottom][left + i];
                grid[bottom][left + i] = grid[bottom - i][right];
                grid[bottom - i][right] = grid[top][right - i];
                grid[top][right - i] = temp;
            }
            top += 1;
            left += 1;
            bottom -= 1;
            right -= 1;
        }
    }
}