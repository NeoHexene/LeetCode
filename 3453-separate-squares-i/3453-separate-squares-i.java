class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double maxy = 0;
        for (int sq[] : squares) {
            int y = sq[1];
            int l = sq[2];
            totalArea += (double) l * l;
            maxy = Math.max(maxy, (double) y + l);
        }

        double left = 0;
        double right = maxy;
        double eps = 1e-5;
        while (Math.abs(right - left) > eps) {
            double mid = (right + left) / 2;
            if (checkArea(mid, squares, totalArea)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean checkArea (double mid, int[][] squares, double totalArea) {
        double currArea = 0;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            if (y < mid) {
                currArea += (double) l * Math.min(mid - y, (double) l);
            }
        }
        return currArea * 2 >= totalArea;
    }
}