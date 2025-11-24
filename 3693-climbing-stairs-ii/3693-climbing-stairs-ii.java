class Solution {
    public int climbStairs(int n, int[] costs) {
        if (n == 1 && costs.length == 1) {
            return costs[0] + 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int step1 = Integer.MAX_VALUE, step2 = Integer.MAX_VALUE, step3 = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                step1 = dp[i-1] + 1;
            }
            if (i - 2 >= 0) {
                step2 = dp[i-2] + 4;
            }
            if (i - 3 >= 0) {
                step3 = dp[i-3] + 9;
            }
            dp[i] = costs[i-1] + (step1 < step2 && step1 < step3 ? step1 : step2 < step3 ? step2 : step3);
        }
        return dp[n];
    }
}