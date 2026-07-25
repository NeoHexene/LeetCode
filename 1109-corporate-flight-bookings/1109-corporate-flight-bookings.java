class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] res = new int[n];

        for (int[] curr : bookings) {
            for (int i = curr[0]; i <= curr[1]; i++) {
                res[i - 1] += curr[2];
            }
        }

        return res;

    }
}