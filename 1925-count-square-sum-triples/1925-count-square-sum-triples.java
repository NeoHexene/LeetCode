class Solution {
    public int countTriples(int n) {
        if (n < 5) {
            return 0;
        } else {
            int low = 1;
            int count = 0;
            while (low < n) {
                int high = n-1;
                while (high > 0) {
                    double sqRt = Math.sqrt((low * low) + (high * high));
                    if (sqRt % 1 == 0 && sqRt <= n) {
                        count ++;
                    }
                    high --;
                }
                low ++;
            }
            return count;
        }
    }
}