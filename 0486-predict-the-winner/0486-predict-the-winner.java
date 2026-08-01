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

    public boolean predictTheWinner(int[] nums) {

        Integer[][] dp = new Integer[nums.length][nums.length];
        return solver(nums, 0, nums.length - 1, dp) >= 0;
    }
}