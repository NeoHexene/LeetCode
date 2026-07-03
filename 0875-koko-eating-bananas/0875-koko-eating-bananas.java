class Solution {
    
    private boolean canEat(int[] piles, int sp, int t) {
        int h = 0;

        for (int i = 0; i < piles.length; i++) {
            h += piles[i] / sp;
            if (piles[i] % sp != 0) {
                h += 1;
            }
            if (h > t) {
                return false;
            }
        }

        return h <= t;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1;

        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEat(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}