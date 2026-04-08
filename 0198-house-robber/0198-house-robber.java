/*
INTUITION:
You are robbing houses arranged in a line, but you cannot rob two adjacent houses.

At each house, you have two choices:
1. Skip the current house → profit = dp[i - 1]
2. Rob the current house → profit = nums[i] + dp[i - 2]

So the decision becomes:
    Take max of (skip vs rob)

This is a classic "take or skip" DP pattern.

-----------------------------------------------------

BRUTE FORCE APPROACH:

Try all subsets of houses such that no two adjacent are chosen.

Time Complexity: O(2^n)
Space Complexity: O(n)

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Use Dynamic Programming:

Define:
dp[i] = maximum money we can rob from houses [0...i]

Transition:
dp[i] = max(
    dp[i - 1],              // skip current house
    nums[i] + dp[i - 2]     // rob current house
)

-----------------------------------------------------

IMPLEMENTED LOGIC:

1. Base cases:
   - dp[0] = nums[0]
   - dp[1] = max(nums[0], nums[1])

2. For each house i:
   - decide whether to rob or skip

3. Final answer:
   - dp[n - 1]

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(n)
*/

class Solution {
    public int rob(int[] nums) {

        // Edge cases
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        // dp[i] = max money we can rob up to house i
        int[] dp = new int[nums.length];

        // Base cases
        dp[0] = nums[0];

        // For second house, choose max of first or second
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill DP array
        for (int i = 2; i < nums.length; i++) {

            // Either skip current house OR rob it
            dp[i] = Math.max(
                dp[i - 1],             // skip
                nums[i] + dp[i - 2]    // rob
            );
        }

        // Result is max profit till last house
        return dp[dp.length - 1];
    }
}