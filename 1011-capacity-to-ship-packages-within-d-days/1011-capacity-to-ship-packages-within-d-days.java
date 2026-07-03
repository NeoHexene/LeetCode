class Solution {

    private boolean canShip(int[] weights, int days, int w) {
        int currDay = 1;
        int tempW = 0;

        for (int i = 0; i < weights.length; i++) {
            if (tempW + weights[i] > w) {
                currDay++;
                tempW = 0;
            }
            tempW += weights[i];
        }

        return currDay <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}