class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long[] prefix = new long[n+1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + damage[i];
        }
        long ans = 0;
        for (int j = 1; j <= n; j++) {
            long threshold = prefix[j] - (hp - requirement[j-1]);
            int k = lowerBound(prefix, threshold);
            if (k <= j - 1) {
                ans+=(j-k);
            }
        }
        return ans;
    }

    private int lowerBound(long[] prefix, long value) {
        int left = 0,  right = prefix.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (prefix[mid] >= value) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}