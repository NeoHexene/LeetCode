class Solution {

    private boolean canMake(int[] bloomDay, int m, int k, int d) {
        int i = 0;
        int count = 0;
        int b = 0;

        while (i < bloomDay.length) {
            if (bloomDay[i] <= d) {
                count++;
            } else {
                b += (count / k);
                count = 0;
            }
            i++;
        }

        b += (count / k);

        return b >= m;
    }


    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * (long) k > (long) bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            high = Math.max(high, bloomDay[i]);
            low = Math.min(low, bloomDay[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}