class Solution {

    private int solver(int[] nums, int l, int r, Integer[][] dp) {
        if (l == r) {
            return nums[l];
        }

        if (dp[l][r] != null) {
            return dp[l][r];
        }

        int takeLeft = nums[l] - solver(nums, l + 1, r, dp);
        int takeRight = nums[r] - solver(nums, l, r - 1, dp);

        dp[l][r] = Math.max(takeLeft, takeRight);

        return dp[l][r];
    }

    public boolean stoneGame(int[] piles) {

        Integer[][] dp = new Integer[piles.length][piles.length];

        return solver(piles, 0, piles.length - 1, dp) >= 0;
    }
}