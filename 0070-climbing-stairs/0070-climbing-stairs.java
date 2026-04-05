/*
INTUITION:
This problem is essentially about counting the number of distinct ways to reach the nth step.
At each step, you can either climb 1 step or 2 steps.

So to reach step n:
- You could have come from (n-1) by taking 1 step
- Or from (n-2) by taking 2 steps

This gives the recurrence:
ways(n) = ways(n-1) + ways(n-2)

This is exactly the Fibonacci sequence.

-----------------------------------------------------

BRUTE FORCE:
Use recursion to try both possibilities (1 step and 2 steps) at every level.

Time Complexity: O(2^n) → exponential (very slow due to repeated work)

-----------------------------------------------------

OPTIMIZED APPROACH:
We use an iterative DP approach with constant space.

Instead of storing the whole DP array, we only keep track of:
- ways to reach (i-2)
- ways to reach (i-1)

Then compute current step using:
curr = prev1 + prev2

-----------------------------------------------------

IMPLEMENTED LOGIC:
- Handle base cases directly (n <= 3)
- Use two variables to simulate Fibonacci progression
- Iterate from 4 to n and keep updating values

-----------------------------------------------------

TIME COMPLEXITY: O(n)
SPACE COMPLEXITY: O(1)
*/

class Solution {
    public int climbStairs(int n) {
        // Base cases:
        // If n is 1 → only 1 way
        // If n is 2 → (1+1), (2) → 2 ways
        // If n is 3 → (1+1+1), (1+2), (2+1) → 3 ways
        if (n <= 3) {
            return n;
        }

        // prev1 = ways to reach step (i-2)
        int prev1 = 2;

        // prev2 = ways to reach step (i-1)
        int prev2 = 3;

        // Start computing from step 4 up to n
        for (int i = 4; i <= n; i++) {
            // Current ways = sum of previous two steps
            int curr = prev1 + prev2;

            // Shift the window forward
            prev1 = prev2;
            prev2 = curr;
        }

        // Final answer stored in prev2 (ways to reach n)
        return prev2;
    }
}