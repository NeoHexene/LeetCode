class Solution {

    private boolean check(int[] candies, long k, int num) {
        long dist = 0;
        for (int c : candies) {
            dist += (c / num);
        }
        return dist >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        int right = 0;
        for (int c : candies) {
            right = Math.max(c, right);
        }
        int left = 0;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(candies, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}