class Solution {
    public List<Integer> spiralOrder(int[][] grid) {
        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;

        List<Integer> res = new ArrayList<>();

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                res.add(grid[top][i]);
            }

            top += 1;

            for (int i = top; i <= bottom; i++) {
                res.add(grid[i][right]);
            }

            right -= 1;

            if (!(left <= right && top <= bottom)) {
                break;
            }

            for (int i = right; i >= left; i--) {
                res.add(grid[bottom][i]);
            }
            
            bottom -= 1;

            for (int i = bottom; i >= top; i--) {
                res.add(grid[i][left]);
            }

            left += 1;
        }
        
        return res;
    }
}