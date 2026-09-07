class Solution {

    public int maxScore(int[] cardPoints, int k) {
        
        int lsum = 0, rsum = 0;

        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }

        int maxsum = lsum;

        for (int lidx = k - 1, ridx = cardPoints.length - 1; lidx >= 0; lidx--, ridx--) {
            lsum -= cardPoints[lidx];
            rsum += cardPoints[ridx];
            maxsum = Math.max(maxsum, lsum + rsum);
        }

        return maxsum;
    }
}