class Solution {
    public List<Integer> spiralOrder(int[][] grid) {
        int top = 0, bottom = grid.length - 1, left = 0, right = grid[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(grid[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res.add(grid[i][right]);
            }
            right--;
            if (!(left <= right && top <= bottom)) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(grid[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res.add(grid[i][left]);
            }
            left++;
        }
        return res;
    }
}