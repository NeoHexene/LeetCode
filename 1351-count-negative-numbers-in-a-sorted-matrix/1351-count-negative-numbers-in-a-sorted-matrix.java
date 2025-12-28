class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] rows : grid) {
            for (int col : rows) {
                if (col < 0) {
                    count += 1;
                }
            }
        }
        return count;
    }
}